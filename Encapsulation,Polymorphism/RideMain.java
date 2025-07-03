abstract class RideVehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public RideVehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Driver: " + driverName + ", Vehicle ID: " + vehicleId);
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLoc);
}

class RideCar extends RideVehicle implements GPS {
    private String location;

    public RideCar(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String loc) {
        location = loc;
    }
}

class RideBike extends RideVehicle implements GPS {
    private String location;

    public RideBike(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String loc) {
        location = loc;
    }
}

public class RideMain {
    public static void main(String[] args) {
        RideVehicle v1 = new RideCar("CAR123", "Ravi", 15);
        RideVehicle v2 = new RideBike("BIKE456", "Amit", 10);

        GPS g1 = (GPS) v1;
        GPS g2 = (GPS) v2;

        g1.updateLocation("Station");
        g2.updateLocation("Mall");

        RideVehicle[] rides = { v1, v2 };

        for (RideVehicle v : rides) {
            v.getVehicleDetails();
            System.out.println("Fare for 10 km: ₹" + v.calculateFare(10));
            System.out.println("Current Location: " + ((GPS)v).getCurrentLocation());
            System.out.println();
        }
    }
}
