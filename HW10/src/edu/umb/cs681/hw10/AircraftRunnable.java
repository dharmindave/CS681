package edu.umb.cs681.hw10;


public class AircraftRunnable extends Aircraft implements Runnable {

    public AircraftRunnable(Position pos) {
        super(pos);
    }

    public void run() {
        Position pos = new Position(43.75, 40.75, 30.75);
        System.out.println("Origin: " + this.getPosition().toString());
        this.setPosition(pos);
        System.out.println("Changed: " + this.getPosition().toString());
    }

    public static void main(String[] args) throws InterruptedException {
        //String street, String city, String state, int zipcode
        Position pos1 = new Position(40.7, -74.01, 21.65);
        Position pos2 = new Position(37.81, -81.47, 40.32);
        Position pos3 = new Position(46.33, -72.55, 53.61);

        Thread t1 = new Thread(new AircraftRunnable(pos1));
        Thread t2 = new Thread(new AircraftRunnable(pos2));
        Thread t3 = new Thread(new AircraftRunnable(pos3));
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }

}