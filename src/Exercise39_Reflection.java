import java.lang.reflect.Method;

class SampleClass {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
    
    private void secretMethod() {
        System.out.println("This is a secret method.");
    }
}

public class Exercise39_Reflection {
    public static void main(String[] args) {
        try {
            // Load the class
            Class<?> clazz = Class.forName("SampleClass");
            System.out.println("Loaded class: " + clazz.getName());
            
            // Create an instance
            Object obj = clazz.getDeclaredConstructor().newInstance();
            
            // Inspect methods
            System.out.println("\nDeclared Methods:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("- " + method.getName() + " | Parameters count: " + method.getParameterCount());
            }
            
            System.out.println("\nInvoking method dynamically:");
            // Invoke public method
            Method sayHelloMethod = clazz.getMethod("sayHello", String.class);
            sayHelloMethod.invoke(obj, "Reflection");
            
            // Invoke private method
            Method secretMethod = clazz.getDeclaredMethod("secretMethod");
            secretMethod.setAccessible(true); // Bypass access check
            secretMethod.invoke(obj);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
