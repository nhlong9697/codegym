import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
  public static void main(String[] args) {
    //ExecutorService executorService = Executors.newCachedThreadPool();
    //executorService.execute(new LazyPrimeFactorization());
    //executorService.execute(new OptimizedPrimeFactorization());
    //executorService.shutdown();
    OptimizedPrimeFactorization optimized = new OptimizedPrimeFactorization();
    LazyPrimeFactorization lazy = new LazyPrimeFactorization();

    //Thread lazyThread = new Thread(lazy);
    //Thread optimizedThread = new Thread(optimized);

    lazy.start();
    optimized.start();
  }

  private static class OptimizedPrimeFactorization extends Thread{

    @Override
    public void run() {
        int i = 0;
        while(true) {
          try {
            if (isPrime(i)) {
              System.out.println("Optimized prime factorization: " + i);
              sleep(1000);
            }
            i++;
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
    }

    private static boolean isPrime(int number) {
      if (number == 0 || number == 1) {
        return false;
      } else if (number == 2) {
        return true;
      } else {
        if (number % 2 == 0) {
          return false;
        }
        else {
          for(int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
              return false;
            }
          }
          return true;
        }
      }
    }
  }

  private static class LazyPrimeFactorization extends Thread{
    public void run() {
        int i = 0;
        while(true) {
          try {
            if (isPrime(i)) {
              System.out.println("LazyPrimeFactorization: " + i);
              sleep(1000);
            }
            i++;
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
    }
    private static boolean isPrime(int number) {
      if (number == 0 || number == 1) {
        return false;
      }
      else {
        for (int i = 2; i < number; i++) {
          if (number % i == 0) {
            return false;
          }
        }
        return true;
      }
    }
  }
}
