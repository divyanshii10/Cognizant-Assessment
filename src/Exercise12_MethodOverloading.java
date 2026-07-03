public class Exercise12_MethodOverloading {
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        Exercise12_MethodOverloading math = new Exercise12_MethodOverloading();
        
        System.out.println("Sum of 2 integers (5, 10): " + math.add(5, 10));
        System.out.println("Sum of 2 doubles (5.5, 10.5): " + math.add(5.5, 10.5));
        System.out.println("Sum of 3 integers (1, 2, 3): " + math.add(1, 2, 3));
    }
}
