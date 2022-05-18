package edu.umb.cs681.hw13;

public class ThreadSafeBankAccountRunnable {

    public static void main(String[] args) {

        ThreadSafeBankAccount2 acc = new ThreadSafeBankAccount2();
        DepositRunnable dep= new DepositRunnable(acc);
        WithdrawRunnable with = new WithdrawRunnable(acc);

        //Threads for Deposit
        Thread d1  = new Thread(dep);
        Thread d2  = new Thread(dep);
        Thread d3  = new Thread(dep);
        Thread d4  = new Thread(dep);
        Thread d5  = new Thread(dep);
        Thread d6  = new Thread(dep);
        Thread d7  = new Thread(dep);
        Thread d8  = new Thread(dep);
        Thread d9  = new Thread(dep);
        Thread d10 = new Thread(dep);
        Thread d11 = new Thread(dep);

        //Threads for withdrawal
        Thread w1  = new Thread(with);
        Thread w2  = new Thread(with);
        Thread w3  = new Thread(with);
        Thread w4  = new Thread(with);
        Thread w5  = new Thread(with);
        Thread w6  = new Thread(with);
        Thread w7  = new Thread(with);
        Thread w8  = new Thread(with);
        Thread w9  = new Thread(with);
        Thread w10  = new Thread(with);
        Thread w11 = new Thread(with);

        d1.start();
        d2.start();
        d3.start();
        d4.start();
        d5.start();
        d6.start();
        d7.start();
        d8.start();
        d9.start();
        d10.start();
        d11.start();

        w1.start();
        w2.start();
        w3.start();
        w4.start();
        w5.start();
        w6.start();
        w7.start();
        w8.start();
        w9.start();
        w10.start();
        w11.start();

        //---------------------------------------------

        dep.setDone();
        with.setDone();

        //---------------------------------------------

        d1.interrupt();
        d2.interrupt();
        d3.interrupt();
        d4.interrupt();
        d5.interrupt();
        d6.interrupt();
        d7.interrupt();
        d8.interrupt();
        d8.interrupt();
        d10.interrupt();
        d11.interrupt();


        //---------------------------------------------

        w1.interrupt();
        w2.interrupt();
        w3.interrupt();
        w4.interrupt();
        w5.interrupt();
        w6.interrupt();
        w7.interrupt();
        w8.interrupt();
        w9.interrupt();
        w10.interrupt();
        w11.interrupt();


        //---------------------------------------------

        try {
            d1.join();
            d2.join();
            d3.join();
            d4.join();
            d5.join();
            d6.join();
            d7.join();
            d8.join();
            d9.join();
            d10.join();
            d11.join();

            w1.join();
            w2.join();
            w3.join();
            w4.join();
            w5.join();
            w6.join();
            w7.join();
            w8.join();
            w9.join();
            w10.join();
            w11.join();

        }catch(InterruptedException e) {
            System.out.println(e);

        }








    }

}