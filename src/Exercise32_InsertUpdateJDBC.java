import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class StudentDAO {
    private String url = "jdbc:sqlite:students.db";
    
    public void insertStudent(String name, int age) {
        String sql = "INSERT INTO students(name, age) VALUES(?, ?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.executeUpdate();
            System.out.println("Student inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateStudentAge(int id, int newAge) {
        String sql = "UPDATE students SET age = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newAge);
            pstmt.setInt(2, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student ID " + id + " updated successfully.");
            } else {
                System.out.println("Student ID " + id + " not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void displayAllStudents() {
        String sql = "SELECT * FROM students";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
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

public class Exercise32_InsertUpdateJDBC {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        
        System.out.println("Inserting new student...");
        dao.insertStudent("Charlie", 25);
        
        System.out.println("\nBefore Update:");
        dao.displayAllStudents();
        
        System.out.println("\nUpdating Charlie's age...");
        // Assuming Charlie might be ID 3 if Alice and Bob were 1 and 2
        dao.updateStudentAge(3, 26);
        
        System.out.println("\nAfter Update:");
        dao.displayAllStudents();
    }
}
