package edu.umb.cs681.hw2;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private String make;
    private String model;
    private int mileage;
    private int year;
    private int price;
    private int dominationCount;

    public Car(String make, String model, int year, int mileage, int price, int dominationCount) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.dominationCount = dominationCount;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDominationCount() {
        return this.dominationCount;
    }
    public static void main(String[] args) {

        List<Car> noofcars = new ArrayList();
        noofcars.add(new Car("Tesla", "X", 2019, 3, 40000, 1));
        noofcars.add(new Car("BMW", "X7", 2018, 4, 28000, 3));
        noofcars.add(new Car("Mercedes", "C-Class", 2020, 2, 25000, 2));
        noofcars.add(new Car("Mustang", "GT", 2016, 12, 31000, 4));
        int highestprice = noofcars.stream().map((Car car) ->car.getPrice() ).reduce(0, (ans,price)->ans > price ? ans : price);
        System.out.println("Costliest Price of a car is :"+highestprice);

        int lowestprice = noofcars.stream().map((Car car) ->car.getPrice() ).reduce(1000000000, (ans, price)->price>ans ? ans : price);
        System.out.println("Cheapest Car Price is :"+lowestprice);

        int averageprice = noofcars.stream().map((Car car) ->car.getPrice() ).reduce(0, (ans,price) -> ans+price, (finalans, intermediateans) -> finalans)/noofcars.size();
        System.out.println("Mean Price of the car is :" + averageprice);
    }
}
