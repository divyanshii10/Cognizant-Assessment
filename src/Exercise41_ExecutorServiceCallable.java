import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exercise41_ExecutorServiceCallable {
    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = new ArrayList<>();
        
        System.out.println("Submitting tasks...");
        
        // Submit 5 Callable tasks
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            Callable<Integer> task = () -> {
                System.out.println("Executing Task " + taskId + " on " + Thread.currentThread().getName());
                Thread.sleep(1000); // Simulate work
                return taskId * 10;
            };
            
            Future<Integer> future = executor.submit(task);
            futures.add(future);
        }
        
        // Collect and print results
        System.out.println("\nCollecting results:");
        for (Future<Integer> future : futures) {
            try {
                // get() blocks until the result is available
                Integer result = future.get();
                System.out.println("Result received: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        
        // Shutdown the executor
        executor.shutdown();
        System.out.println("Executor shut down.");
    }
}
