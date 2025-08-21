import java.util.*;
import java.util.stream.Collectors;

class InsuranceClaim {
    private String claimId;
    private String claimType;
    private double claimAmount;

    public InsuranceClaim(String claimId, String claimType, double claimAmount) {
        this.claimId = claimId;
        this.claimType = claimType;
        this.claimAmount = claimAmount;
    }

    public String getClaimType() {
        return claimType;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    @Override
    public String toString() {
        return "Claim ID: " + claimId + ", Type: " + claimType + ", Amount: " + claimAmount;
    }
}

public class InsuranceClaimAnalysis {
    public static void main(String[] args) {
        // Sample data
        List<InsuranceClaim> claims = Arrays.asList(
            new InsuranceClaim("C001", "Health", 15000),
            new InsuranceClaim("C002", "Vehicle", 25000),
            new InsuranceClaim("C003", "Health", 10000),
            new InsuranceClaim("C004", "Home", 30000),
            new InsuranceClaim("C005", "Vehicle", 20000),
            new InsuranceClaim("C006", "Home", 35000),
            new InsuranceClaim("C007", "Health", 12000)
        );

        // Group by claim type and calculate average amount
        Map<String, Double> averageClaimAmountByType = claims.stream()
            .collect(Collectors.groupingBy(
                InsuranceClaim::getClaimType,
                Collectors.averagingDouble(InsuranceClaim::getClaimAmount)
            ));

        // Display results
        System.out.println("Average Claim Amount by Type:");
        averageClaimAmountByType.forEach((type, avgAmount) ->
            System.out.println(type + " → " + avgAmount)
        );
    }
}
