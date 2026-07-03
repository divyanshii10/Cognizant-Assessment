public class Exercise37_JavapInspect {
    
    public int calculateSum(int a, int b) {
        return a + b;
    }
    
    public static void main(String[] args) {
        System.out.println("Compile this class using: javac Exercise37_JavapInspect.java");
        System.out.println("Then inspect the bytecode using: javap -c Exercise37_JavapInspect");
        
        Exercise37_JavapInspect obj = new Exercise37_JavapInspect();
        int result = obj.calculateSum(5, 7);
        System.out.println("Result: " + result);
    }
}
