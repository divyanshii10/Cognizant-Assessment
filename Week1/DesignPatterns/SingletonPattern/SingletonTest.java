public class SingletonTest {
    public static void main(String[] args) {
        // Attempt to get two instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Verify if both references point to the same object
        if (logger1 == logger2) {
            System.out.println("Singleton Pattern Implementation is Correct.");
            System.out.println("Both logger1 and logger2 point to the same instance.");
        } else {
            System.out.println("Singleton Pattern Implementation is Incorrect.");
        }

        logger1.log("This is a test message.");
    }
}
