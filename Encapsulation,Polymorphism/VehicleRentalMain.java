abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    public Car(String num, String type, double rate) {
        super(num, type, rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 1000;
    }

    public String getInsuranceDetails() {
        return "Car Insurance ₹1000";
    }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String num, String type, double rate) {
        super(num, type, rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 300;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance ₹300";
    }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String num, String type, double rate) {
        super(num, type, rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500;
    }

    public double calculateInsurance() {
        return 2000;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance ₹2000";
    }
}

public class VehicleRentalMain {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("MH12AB1234", "Sedan", 1500),
            new Bike("MH12XY6789", "Bike", 500),
            new Truck("MH12TR0001", "Heavy", 2500)
        };

        for (Vehicle v : vehicles) {
            System.out.println("Vehicle: " + v.getVehicleNumber() + " (" + v.getType() + ")");
            System.out.println("Rental for 3 days: ₹" + v.calculateRentalCost(3));
            Insurable ins = (Insurable) v;
            System.out.println("Insurance: ₹" + ins.calculateInsurance());
            System.out.println(ins.getInsuranceDetails());
            System.out.println();
        }
    }
}
