public class Exercise40_VirtualThreads {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        
        System.out.println("Launching 100,000 virtual threads...");
        
        try {
            for (int i = 0; i < 100_000; i++) {
                final int threadId = i;
                Thread.startVirtualThread(() -> {
                    // Simulating some work
                    try {
                        Thread.sleep(100); 
                        // To avoid cluttering the console, we won't print all 100,000 messages.
                        // Uncomment below to see individual prints
                        // System.out.println("Virtual Thread " + threadId + " says hello!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
            
            // Sleep briefly to let threads finish (not robust, but simple for demo)
            Thread.sleep(1000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("Finished launching virtual threads.");
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}
