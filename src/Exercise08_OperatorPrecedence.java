public class Exercise08_OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;
        System.out.println("Expression: 10 + 5 * 2");
        System.out.println("Result: " + result);
        System.out.println("Explanation: Multiplication (*) has higher precedence than addition (+), so 5 * 2 is evaluated first (10), then 10 is added, resulting in 20.");
        
        int resultWithParentheses = (10 + 5) * 2;
        System.out.println("\nExpression: (10 + 5) * 2");
        System.out.println("Result: " + resultWithParentheses);
        System.out.println("Explanation: Parentheses change precedence, so 10 + 5 is evaluated first (15), then multiplied by 2, resulting in 30.");
    }
}
