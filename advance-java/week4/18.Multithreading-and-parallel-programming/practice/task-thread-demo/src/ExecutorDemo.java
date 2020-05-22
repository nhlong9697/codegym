import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
  public static void main(String[] args) {
    //start a thread pool with maximum 3 thread run concurrently
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    //start only 1 thread run concurrently and 3 task will be execute sequentially
    //ExecutorService executorService = Executors.newFixedThreadPool(i);
    //new thread will be created for each task and run concurrently
    //ExecutorService executorService = Executors.newCachedThreadPool();

    executorService.execute(new PrintChar('a',100));
    executorService.execute(new PrintChar('b',100));
    executorService.execute(new PrintNum(100));

    //tell the executor to shutdown and no new task can be accepted but existing task will continue to run
    executorService.shutdown();
  }
}
