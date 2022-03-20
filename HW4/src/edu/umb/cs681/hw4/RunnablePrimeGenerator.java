package edu.umb.cs681.hw4;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {
    public RunnablePrimeGenerator(long from, long to) {
        super(from, to);
    }
    public void run() {
        generatePrimes();
    }

    public static void main(String[] args) {
        System.out.println("\nElapsed Time For Threads:");

        RunnablePrimeGenerator rpg1 = new RunnablePrimeGenerator(1,2000000);
        Thread th = new Thread(rpg1);

        long startt1 = System.currentTimeMillis();
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
        }

        long stopt1 = System.currentTimeMillis();
        long elapsedt1 = stopt1 - startt1;

        rpg1.getPrimes().forEach((Long prime) -> System.out.print(prime + ", "));

        long primenumbers = rpg1.getPrimes().size();
        System.out.println("\n  total prime numbers found are : " + primenumbers );
        System.out.println("1) Thread elapsed time: " + elapsedt1 + " ms");


        RunnablePrimeGenerator rpg1c2 = new RunnablePrimeGenerator(1, 1000000);
        RunnablePrimeGenerator rpg2c2 = new RunnablePrimeGenerator(1000001, 2000000);
        Thread th1 = new Thread(rpg1c2);
        Thread th2 = new Thread(rpg2c2);

        long startt2 = System.currentTimeMillis();
        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
        }

        long stopt2 = System.currentTimeMillis();
        long elapsedt2 = stopt2 - startt2;
        System.out.println("2) Threads elapsed time: " + elapsedt2 + " ms");

        // Multi-threaded (4 threads) prime number generation (with generatePrimes())
        RunnablePrimeGenerator rpg1c3 = new RunnablePrimeGenerator(1, 500000);
        RunnablePrimeGenerator rpg2c3 = new RunnablePrimeGenerator(500001, 1000000);
        RunnablePrimeGenerator rpg3c3 = new RunnablePrimeGenerator(1000001, 1500000);
        RunnablePrimeGenerator rpg4c3 = new RunnablePrimeGenerator(1500001, 2000000);
        Thread th4_1 = new Thread(rpg1c3);
        Thread th4_2 = new Thread(rpg2c3);
        Thread th4_3 = new Thread(rpg3c3);
        Thread th4_4 = new Thread(rpg4c3);

        long startt4 = System.currentTimeMillis();
        th4_1.start();
        th4_2.start();
        th4_3.start();
        th4_4.start();
        try {
            th4_1.join();
            th4_2.join();
            th4_3.join();
            th4_4.join();
        } catch (InterruptedException e) {
        }

        long stopt4 = System.currentTimeMillis();
        long elapsedt4 = stopt4 - startt4;
        System.out.println("4) Threads elapsed time: " + elapsedt4 + " ms");


        RunnablePrimeGenerator rpg1c4 = new RunnablePrimeGenerator(1, 250000);
        RunnablePrimeGenerator rpg2c4 = new RunnablePrimeGenerator(250001, 500000);
        RunnablePrimeGenerator rpg3c4 = new RunnablePrimeGenerator(500001, 750000);
        RunnablePrimeGenerator rpg4c4 = new RunnablePrimeGenerator(750001, 1000000);
        RunnablePrimeGenerator rpg5c4 = new RunnablePrimeGenerator(1000001, 1250000);
        RunnablePrimeGenerator rpg6c4 = new RunnablePrimeGenerator(1250001, 1500000);
        RunnablePrimeGenerator rpg7c4 = new RunnablePrimeGenerator(1500001, 1750000);
        RunnablePrimeGenerator rpg8c4 = new RunnablePrimeGenerator(1750001, 2000000);
        Thread th8_1 = new Thread(rpg1c4);
        Thread th8_2 = new Thread(rpg2c4);
        Thread th8_3 = new Thread(rpg3c4);
        Thread th8_4 = new Thread(rpg4c4);
        Thread th8_5 = new Thread(rpg5c4);
        Thread th8_6 = new Thread(rpg6c4);
        Thread th8_7 = new Thread(rpg7c4);
        Thread th8_8 = new Thread(rpg8c4);

        long startt8 = System.currentTimeMillis();
        th8_1.start();
        th8_2.start();
        th8_3.start();
        th8_4.start();
        th8_5.start();
        th8_6.start();
        th8_7.start();
        th8_8.start();
        try {
            th8_1.join();
            th8_2.join();
            th8_3.join();
            th8_4.join();
            th8_5.join();
            th8_6.join();
            th8_7.join();
            th8_8.join();
        } catch (InterruptedException e) {
        }

        long stopt8 = System.currentTimeMillis();
        long elapsedt8 = stopt8 - startt8;
        System.out.println("8) Threads elapsed time: " + elapsedt8 + " ms");


        RunnablePrimeGenerator rpg1c5 = new RunnablePrimeGenerator(1, 125000);
        RunnablePrimeGenerator rpg2c5 = new RunnablePrimeGenerator(125001, 250000);
        RunnablePrimeGenerator rpg3c5 = new RunnablePrimeGenerator(250001, 375000);
        RunnablePrimeGenerator rpg4c5 = new RunnablePrimeGenerator(375001, 500000);
        RunnablePrimeGenerator rpg5c5 = new RunnablePrimeGenerator(500001, 625000);
        RunnablePrimeGenerator rpg6c5 = new RunnablePrimeGenerator(625001, 750000);
        RunnablePrimeGenerator rpg7c5 = new RunnablePrimeGenerator(750001, 875000);
        RunnablePrimeGenerator rpg8c5 = new RunnablePrimeGenerator(875001, 1000000);
        RunnablePrimeGenerator rpg9c5 = new RunnablePrimeGenerator(1000001, 1125000);
        RunnablePrimeGenerator rpg10c5 = new RunnablePrimeGenerator(1125001, 1250000);
        RunnablePrimeGenerator rpg11c5 = new RunnablePrimeGenerator(1250001, 1375000);
        RunnablePrimeGenerator rpg12c5 = new RunnablePrimeGenerator(1375001, 1500000);
        RunnablePrimeGenerator rpg13c5 = new RunnablePrimeGenerator(1500001, 1625000);
        RunnablePrimeGenerator rpg14c5 = new RunnablePrimeGenerator(1625001, 1750000);
        RunnablePrimeGenerator rpg15c5 = new RunnablePrimeGenerator(1750001, 1875000);
        RunnablePrimeGenerator rpg16c5 = new RunnablePrimeGenerator(1875001, 2000000);

        Thread th16_1 = new Thread(rpg1c5);
        Thread th16_2 = new Thread(rpg2c5);
        Thread th16_3 = new Thread(rpg3c5);
        Thread th16_4 = new Thread(rpg4c5);
        Thread th16_5 = new Thread(rpg5c5);
        Thread th16_6 = new Thread(rpg6c5);
        Thread th16_7 = new Thread(rpg7c5);
        Thread th16_8 = new Thread(rpg8c5);
        Thread th16_9 = new Thread(rpg9c5);
        Thread th16_10 = new Thread(rpg10c5);
        Thread th16_11 = new Thread(rpg11c5);
        Thread th16_12 = new Thread(rpg12c5);
        Thread th16_13 = new Thread(rpg13c5);
        Thread th16_14 = new Thread(rpg14c5);
        Thread th16_15 = new Thread(rpg15c5);
        Thread th16_16 = new Thread(rpg16c5);
        long startt16 = System.currentTimeMillis();
        th16_1.start();
        th16_2.start();
        th16_3.start();
        th16_4.start();
        th16_5.start();
        th16_6.start();
        th16_7.start();
        th16_8.start();
        th16_9.start();
        th16_10.start();
        th16_11.start();
        th16_12.start();
        th16_13.start();
        th16_14.start();
        th16_15.start();
        th16_16.start();
        try {
            th16_1.join();
            th16_2.join();
            th16_3.join();
            th16_4.join();
            th16_5.join();
            th16_6.join();
            th16_7.join();
            th16_8.join();
            th16_9.join();
            th16_10.join();
            th16_11.join();
            th16_12.join();
            th16_13.join();
            th16_14.join();
            th16_15.join();
            th16_16.join();
        } catch (InterruptedException e) {
        }

        long stopt16 = System.currentTimeMillis();
        long elapsedt16 = stopt16 - startt16;
        System.out.println("16) Threads elapsed time: " + elapsedt16 + " ms");

    }

}