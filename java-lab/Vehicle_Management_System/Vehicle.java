package Vehicle_Management_System;
public class Vehicle {

    //  DATA MEMBERS
    // Public data members
    public String brandName;
    public String modelName;
    public double price;

    // Private data members (Encapsulation)
    private double mileage;
    private int speed;

    // CONSTRUCTORS
    // 1. DEFAULT CONSTRUCTOR
    public Vehicle() {
        brandName = "Not Set";
        modelName = "Not Set";
        price = 0;
        mileage = 0;
        speed = 0;
    }

    // 2. PARAMETERIZED CONSTRUCTOR
    public Vehicle(String brandName, String modelName, double price) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.price = price;
        this.mileage = 0;
        this.speed = 0;
    }

    // 3. COPY CONSTRUCTOR
    public Vehicle(Vehicle v) {
        this.brandName = v.brandName;
        this.modelName = v.modelName;
        this.price = v.price;
        this.mileage = v.mileage;
        this.speed = v.speed;
    }

    // GETTERS & SETTERS
    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getMileage() {
        return mileage;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    // METHODS
    public void start() {
        System.out.println(brandName + " started");
    }

    public void drive() {
        System.out.println(brandName + " is driving");
    }

    public void stop() {
        System.out.println(brandName + " stopped");
    }

    // Calculate mileage
    public void calcMileage(double distance, double fuelUsed) {
        if (fuelUsed > 0) {
            mileage = distance / fuelUsed;
        }
    }

    // Change speed
    public void changeSpeed(int change) {
        speed += change;
    }
}