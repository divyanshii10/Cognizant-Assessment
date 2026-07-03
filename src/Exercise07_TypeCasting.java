public class Exercise07_TypeCasting {
    public static void main(String[] args) {
        // Double to Int
        double myDouble = 45.75;
        int myInt = (int) myDouble; // Explicit casting
        
        System.out.println("Original double value: " + myDouble);
        System.out.println("Double casted to int: " + myInt);
        
        // Int to Double
        int anotherInt = 150;
        double anotherDouble = anotherInt; // Implicit casting
        
        System.out.println("\nOriginal int value: " + anotherInt);
        System.out.println("Int casted to double: " + anotherDouble);
    }
}
