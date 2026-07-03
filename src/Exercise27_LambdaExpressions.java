import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise27_LambdaExpressions {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Mango");
        fruits.add("Grapes");
        
        System.out.println("Original list: " + fruits);
        
        // Sorting using a lambda expression
        Collections.sort(fruits, (s1, s2) -> s1.compareTo(s2));
        
        System.out.println("Sorted list (alphabetical): " + fruits);
        
        // Sorting in reverse order
        Collections.sort(fruits, (s1, s2) -> s2.compareTo(s1));
        
        System.out.println("Sorted list (reverse alphabetical): " + fruits);
    }
}
