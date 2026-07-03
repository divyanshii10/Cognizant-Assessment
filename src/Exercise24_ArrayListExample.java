import java.util.ArrayList;
import java.util.Scanner;

public class Exercise24_ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter a student name (or type 'exit' to stop): ");
            String name = scanner.nextLine();
            
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            
            students.add(name);
        }
        
        System.out.println("\nList of students entered:");
        for (String student : students) {
            System.out.println("- " + student);
        }
    }
}
