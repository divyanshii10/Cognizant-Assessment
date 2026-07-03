import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class Exercise33_TransactionJDBC {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:bank.db";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            
            // Setup
            stmt.execute("CREATE TABLE IF NOT EXISTS accounts (id INTEGER PRIMARY KEY, balance REAL)");
            stmt.execute("DELETE FROM accounts"); // clear previous run
            stmt.execute("INSERT INTO accounts (id, balance) VALUES (1, 1000.0)");
            stmt.execute("INSERT INTO accounts (id, balance) VALUES (2, 500.0)");
            
            System.out.println("Initial balances: ");
            printBalances(conn);
            
            // Transaction
            conn.setAutoCommit(false);
            
            String withdrawSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            String depositSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            
            try (PreparedStatement withdrawStmt = conn.prepareStatement(withdrawSQL);
                 PreparedStatement depositStmt = conn.prepareStatement(depositSQL)) {
                
                double transferAmount = 200.0;
                
                // Withdraw from Account 1
                withdrawStmt.setDouble(1, transferAmount);
                withdrawStmt.setInt(2, 1);
                withdrawStmt.executeUpdate();
                
                // Simulate an error here to test rollback, uncomment next line to see it fail:
                // if (true) throw new RuntimeException("Simulated error during transfer");
                
                // Deposit to Account 2
                depositStmt.setDouble(1, transferAmount);
                depositStmt.setInt(2, 2);
                depositStmt.executeUpdate();
                
                // Both succeeded, commit
                conn.commit();
                System.out.println("\nTransfer of " + transferAmount + " successful.");
                
            } catch (Exception e) {
                System.out.println("\nTransfer failed. Rolling back.");
                conn.rollback();
            } finally {
                conn.setAutoCommit(true);
            }
            
            System.out.println("\nFinal balances: ");
            printBalances(conn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void printBalances(Connection conn) throws Exception {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM accounts")) {
            while (rs.next()) {
                System.out.println("Account " + rs.getInt("id") + " Balance: " + rs.getDouble("balance"));
            }
        }
    }
}
