import java.util.*;

public class EmailNotifications {
    public static void main(String[] args) {
        // Sample list of user emails
        List<String> emails = Arrays.asList(
            "john.doe@example.com",
            "emma.smith@example.com",
            "sophia.williams@example.com",
            "david.jones@example.com"
        );

        // Send email notifications
        emails.forEach(email -> sendEmailNotification(email));
    }

    // Simulated email sending method
    private static void sendEmailNotification(String email) {
        System.out.println("Sending notification to: " + email);
    }
}
