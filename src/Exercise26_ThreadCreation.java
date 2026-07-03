class MessageThread extends Thread {
    private String message;
    
    public MessageThread(String message) {
        this.message = message;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + message + " (Count: " + i + ")");
            try {
                Thread.sleep(500); // Sleep for 500ms
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}

public class Exercise26_ThreadCreation {
    public static void main(String[] args) {
        System.out.println("Starting threads...");
        
        MessageThread thread1 = new MessageThread("Hello from Thread 1!");
        MessageThread thread2 = new MessageThread("Hi from Thread 2!");
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Both threads have finished execution.");
    }
}
