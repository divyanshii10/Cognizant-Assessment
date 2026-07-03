import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exercise31_BasicJDBC {
    public static void main(String[] args) {
        // We will use SQLite for simplicity (no server setup required)
        String url = "jdbc:sqlite:students.db";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            
            // Create table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS students ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "name TEXT NOT NULL,"
                    + "age INTEGER)";
            stmt.execute(createTableSQL);
            System.out.println("Table 'students' created or already exists.");
            
            // Insert dummy data if table is empty
            ResultSet rsCheck = stmt.executeQuery("SELECT count(*) FROM students");
            if (rsCheck.next() && rsCheck.getInt(1) == 0) {
                stmt.execute("INSERT INTO students (name, age) VALUES ('Alice', 20)");
                stmt.execute("INSERT INTO students (name, age) VALUES ('Bob', 22)");
            }
            
            // Retrieve and print data
            System.out.println("\nRetrieving data from database:");
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + 
                                   ", Name: " + rs.getString("name") + 
                                   ", Age: " + rs.getInt("age"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
