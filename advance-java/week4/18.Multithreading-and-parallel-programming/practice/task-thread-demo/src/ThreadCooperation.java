import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCooperation {
  private static Account account = new Account();

  public static void main(String[] args) {
    ExecutorService executorService1 = Executors.newFixedThreadPool(2);
    executorService1.execute(new DepositTask());
    executorService1.execute(new WithdrawTask());
    executorService1.shutdown();
    System.out.println("Thread 1\t\tThread2\t\tBalance");
  }

  public static class DepositTask implements Runnable {
    @Override
    public void run() {
      try {
        while(true) {
          account.deposit((int)(Math.random() * 10) + 1);
          Thread.sleep(2000);
        }
      } catch (InterruptedException exception) {
        exception.printStackTrace();
      }
    }
  }
  public static class WithdrawTask implements Runnable {
    @Override
    public void run() {
      while(true) {
        account.withdraw((int)(Math.random() * 10) + 1);
      }
    }
  }
  private static class Account {
    private static Lock lock = new ReentrantLock();

    private static Condition newDeposit = lock.newCondition();

    private int balance = 0;

    public int getBalance() {
      return this.balance;
    }

    public void withdraw(int amount) {
      lock.lock();
      try {
        while (balance < amount) {
          System.out.println("\t\t\tWait for a deposit");
          newDeposit.await();
          //if using if statement in stead of while the block of code will continue to run
          //which is balance -= amount and the condition of balance < amount might be true
          //however if it is a loop the function continue to run but the while condition will be checked
          //while (balance < amount) is false the block of code wont be run => no newDeposit.await()
          //next statement
        }
        balance -= amount;
        System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
      finally {
        lock.unlock();
      }
    }
    public void deposit(int amount) {
      lock.lock();
      try {
        balance += amount;
        System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
        //signal the thread
        newDeposit.signalAll();
      } catch (Exception exception) {
        exception.printStackTrace();
      }
      finally {
        lock.unlock();
      }
    }
  }
}
