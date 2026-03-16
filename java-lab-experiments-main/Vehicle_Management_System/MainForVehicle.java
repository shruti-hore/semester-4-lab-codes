package Vehicle_Management_System;
public class MainForVehicle {

    public static void main(String[] args) {
        // Creating Vehicle objects
        // Using DEFAULT constructor
        Vehicle v1 = new Vehicle();
        v1.brandName = "Honda";
        v1.modelName = "City";
        v1.price = 1200000;
        v1.calcMileage(500, 25);

        // Using PARAMETERIZED constructor
        Vehicle v2 = new Vehicle("Hyundai", "Creta", 1500000);
        v2.calcMileage(600, 30);

        // Using COPY constructor
        Vehicle v3 = new Vehicle(v2);
        v3.brandName = "Hyundai Copy";

        // Array of Vehicle objects
        Vehicle[] vehicles = { v1, v2, v3 };

        System.out.println("------------------------------------------------------------");
        System.out.printf("%-15s %-15s %-12s %-10s%n",
                "Brand Name", "Model Name", "Price", "Mileage");
        System.out.println("------------------------------------------------------------");


        for (Vehicle v : vehicles) {
            System.out.printf("%-15s %-15s %-12.2f %-10.2f%n",
                    v.brandName,
                    v.modelName,
                    v.price,
                    v.getMileage());
        }

        System.out.println("------------------------------------------------------------");
    }
}
