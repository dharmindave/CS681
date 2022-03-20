package edu.umb.cs681.hw5;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeGenerator extends RunnablePrimeGenerator {
    private boolean done = false;
    private ReentrantLock lock = new ReentrantLock();

    public RunnableCancellablePrimeGenerator(long from, long to) {
        super(from, to);
    }

    public void setDone() {
        lock.lock();

        try {
            done = true;
        } finally {
            lock.unlock();
        }
    }

    public void generatePrimes() {
        for (long n = from; n <= to; n++) {
            lock.lock();
            try {
                if (done) {
                    System.out.println("Prime Numbers Generation Stopped");
                    this.primes.clear();
                    break;
                }
                if (isPrime(n)) {
                    this.primes.add(n);
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        RunnableCancellablePrimeGenerator gen = new RunnableCancellablePrimeGenerator(1,1000);
        Thread thread = new Thread(gen);
        thread.start();
        gen.setDone();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gen.getPrimes().forEach((Long prime) -> System.out.print(prime + ", "));
        System.out.println("\n" + gen.getPrimes().size() + " Prime Number are found");
    }
}