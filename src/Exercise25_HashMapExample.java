import java.util.HashMap;
import java.util.Scanner;

public class Exercise25_HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        
        studentMap.put(101, "Alice");
        studentMap.put(102, "Bob");
        studentMap.put(103, "Charlie");
        
        System.out.println("Current students in the map:");
        for (Integer id : studentMap.keySet()) {
            System.out.println("ID: " + id + ", Name: " + studentMap.get(id));
        }
        
        System.out.print("\nEnter a new Student ID to add: ");
        int newId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        System.out.print("Enter Student Name: ");
        String newName = scanner.nextLine();
        
        studentMap.put(newId, newName);
        System.out.println("Added student successfully.\n");
        
        System.out.print("Enter a Student ID to retrieve their name: ");
        int searchId = scanner.nextInt();
        
        if (studentMap.containsKey(searchId)) {
            System.out.println("Student Name: " + studentMap.get(searchId));
        } else {
            System.out.println("Student with ID " + searchId + " not found.");
        }
    }
}
