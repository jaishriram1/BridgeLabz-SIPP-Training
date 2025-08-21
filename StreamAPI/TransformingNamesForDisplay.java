import java.util.*;
import java.util.stream.Collectors;

public class TransformingNamesForDisplay {
    public static void main(String[] args) {
        // Sample data: List of customer names
        List<String> customerNames = Arrays.asList(
            "Sophia",
            "john",
            "Emma",
            "alex",
            "David",
            "lily"
        );

        // Transform names to uppercase and sort alphabetically
        List<String> transformedNames = customerNames.stream()
            .map(String::toUpperCase)       // Convert to uppercase
            .sorted()                       // Sort alphabetically
            .collect(Collectors.toList());  // Collect results

        // Display results
        System.out.println("Customer Names in Uppercase and Alphabetical Order:");
        transformedNames.forEach(System.out::println);
    }
}
