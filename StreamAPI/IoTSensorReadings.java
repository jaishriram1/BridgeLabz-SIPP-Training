import java.util.*;
import java.util.stream.*;

public class IoTSensorReadings {
    public static void main(String[] args) {
        // Simulated IoT sensor temperature readings
        List<Double> readings = Arrays.asList(25.5, 32.1, 28.0, 35.7, 30.5, 22.4);

        double threshold = 30.0;

        System.out.println("Sensor Readings Above Threshold (" + threshold + "°C):");
        readings.stream()
                .filter(reading -> reading > threshold)      // Filter readings above threshold
                .forEach(reading -> System.out.println("High Reading: " + reading + "°C"));
    }
}
