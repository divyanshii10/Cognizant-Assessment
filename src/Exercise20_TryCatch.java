import java.util.Scanner;

public class Exercise20_TryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first integer (numerator): ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter the second integer (denominator): ");
        int num2 = scanner.nextInt();
        
        try {
            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }
    }
}
