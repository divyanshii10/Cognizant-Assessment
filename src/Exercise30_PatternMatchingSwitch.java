public class Exercise30_PatternMatchingSwitch {
    
    public static void determineType(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("It's an Integer with value: " + i);
            case String s -> System.out.println("It's a String of length " + s.length() + ": " + s);
            case Double d -> System.out.println("It's a Double with value: " + d);
            case Boolean b -> System.out.println("It's a Boolean with value: " + b);
            case null -> System.out.println("It's a null value.");
            default -> System.out.println("Unknown type: " + obj.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        Object[] objects = {
            100,
            "Hello Java 21",
            45.99,
            true,
            null,
            new Object()
        };
        
        for (Object obj : objects) {
            determineType(obj);
        }
    }
}
