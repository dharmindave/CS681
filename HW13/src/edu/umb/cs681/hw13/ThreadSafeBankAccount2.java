package edu.umb.cs681.hw13;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeBankAccount2 {
    private double balance = 0;
    private final ReentrantLock lock = new ReentrantLock();


    Condition sufficientFundsCondition = lock.newCondition();
    Condition belowUpperLimitFundsCondition = lock.newCondition();
    public void withdraw(double amount){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t Current Balance is :" + balance);
            while (balance <= 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + "\t Balance is low! : Await Withdraw");
                    sufficientFundsCondition.await();// temporarily releases the lock and goes to  the Waiting state
                                                     // til  getting signaled by another thread
                }
                catch (InterruptedException e) {
                    return;
                }
            }

            balance -= amount;
            System.out.println(Thread.currentThread().getName() + "\t New Balance after withdrawal: " + balance);
            belowUpperLimitFundsCondition.signalAll();

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            System.out.println("Lock Removed");
            lock.unlock();


        }
    }
    public void deposit(double amount){

        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + "\t Current Balance is : " + balance);
            while (balance >= 300) {
                try {
                    System.out.println(Thread.currentThread().getName() + "\t Balance exceeded limit!	: Await Deposit");
                    belowUpperLimitFundsCondition.await();
                }
                catch (InterruptedException e) {
                    return;
                }
            }

            balance += amount;
            System.out.println(Thread.currentThread().getName() + "\t Updated Balance after deposit	: " + balance);
            sufficientFundsCondition.signalAll();

        } catch (Exception e1) {

            e1.printStackTrace();
        } finally {
            System.out.println("Lock Removed");
            lock.unlock();
        }
    }


}
