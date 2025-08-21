import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

class GymMember {
    private String name;
    private LocalDate expiryDate;

    public GymMember(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Member: " + name + ", Expiry Date: " + expiryDate;
    }
}

public class FilteringExpiringMemberships {
    public static void main(String[] args) {
        // Sample data: List of gym members
        List<GymMember> members = Arrays.asList(
            new GymMember("John", LocalDate.now().plusDays(10)),
            new GymMember("Emma", LocalDate.now().plusDays(25)),
            new GymMember("Alex", LocalDate.now().plusDays(40)),
            new GymMember("Sophia", LocalDate.now().minusDays(5)),
            new GymMember("David", LocalDate.now().plusDays(5)),
            new GymMember("Lily", LocalDate.now().plusDays(60))
        );

        LocalDate today = LocalDate.now();

        // Filter members whose membership expires within the next 30 days
        List<GymMember> expiringSoon = members.stream()
            .filter(member -> {
                long daysBetween = ChronoUnit.DAYS.between(today, member.getExpiryDate());
                return daysBetween >= 0 && daysBetween <= 30;
            })
            .collect(Collectors.toList());

        // Display results
        System.out.println("Members whose membership expires within the next 30 days:");
        expiringSoon.forEach(System.out::println);
    }
}
