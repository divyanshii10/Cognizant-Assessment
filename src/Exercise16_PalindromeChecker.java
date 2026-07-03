import java.util.Scanner;

public class Exercise16_PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        // Remove non-alphanumeric characters and convert to lowercase
        String cleanedStr = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        String reversedStr = new StringBuilder(cleanedStr).reverse().toString();
        
        if (cleanedStr.equals(reversedStr)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }
    }
}
