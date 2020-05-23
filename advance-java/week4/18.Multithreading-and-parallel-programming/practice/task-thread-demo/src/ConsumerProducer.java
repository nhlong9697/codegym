import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProducer {
  private static Buffer buffer = new Buffer();
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.execute(new ProduceTask());
    executorService.execute(new ConsumeTask());
    executorService.shutdown();
  }

  private static class ProduceTask implements Runnable {
    public void run() {
      try {
        int i = 1;
        while (true) {
          System.out.println("Producer produce " + i + "th times");
          buffer.produce(i++);
          Thread.sleep((int)(Math.random() * 1000));
        }
      } catch (InterruptedException exception) {
        exception.printStackTrace();
      }
    }
  }

  private static class ConsumeTask implements Runnable {

    public void run() {
      try {
        while (true) {
          System.out.println("Consumer consume " + buffer.consume() + "th times");
          Thread.sleep((int)(Math.random() * 10000));
        }
      } catch (InterruptedException exception) {
        exception.printStackTrace();
      }
    }
  }

  private static class Buffer {
    private static final int CAPACITY = 1;
    private LinkedList<Integer> queue = new LinkedList<>();

    private static Lock lock = new ReentrantLock();

    private static Condition notEmpty = lock.newCondition();
    private static Condition notFull = lock.newCondition();

    public void produce(int value) {
      lock.lock();
      try {
        while(queue.size() == CAPACITY) {
          System.out.println("queue is full");
          notFull.await();
        }
        queue.addLast(value);
        notEmpty.signalAll();
      } catch (InterruptedException exception) {
        exception.printStackTrace();
      } finally {
        lock.unlock();
      }
    }

    public int consume() {
      int value = 0;
      lock.lock();
      try {
        while(queue.isEmpty()) {
          System.out.println("queue is empty");
          notEmpty.await();
        }
        value = queue.remove();
        notFull.signalAll();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
        return value;
      }
    }
  }
}


