import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithoutSync {
  private static Account account = new Account();

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();

    for (int i = 0; i < 100; i++) {
      executorService.execute(new AddAPennyTask());
    }

    //no more new task add
    executorService.shutdown();

    //wait until all task are done
    while(!executorService.isTerminated()) {
    }

    System.out.println("What is the balance?" + account.getBalance());
  }
  private static class Account {
    private int balance = 0;

    public int getBalance() {
      return this.balance;
    }

    //the add a peny task below executed 100 times in main will only add a small amount to the balance because
    //before assign balance = newBalance the thread will be put to sleep for another thread
    //in the executor service to run
    //another thread will run deposit(int amount) again => newBalance = balance + amount will run before
    //the reassign of balance = newBalance is run therefore balance will stay the same as
    // before balance is reassign at balance = newBalance
    //this is race condition when two task accessing the same resource
    //the synchronized keyword aim to solve the problem
    //prevent more than one thread from simultaneously run the same resource or entering the critical region
    //synchronized keyword to synchronized the method so that only one thread can access a method at a time
    public void deposit(int amount) {
      int newBalance = balance + amount;

      try {
        Thread.sleep(5);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      balance = newBalance;
    }
  }
  //synchronized (object) {
  //  statements;
  //}
  //if the object is already locked by another thread
  //the thread is block until the lock is release
  //if synchronized(this) the thread will have a block while the account.deposit will still run concurrently
  //the problem will still happen where newBalance = balance + amount before it is reassign
  private static class AddAPennyTask implements Runnable {
    public void run() {
      synchronized (account) {
        account.deposit(1);
      }
    }
  }
}
