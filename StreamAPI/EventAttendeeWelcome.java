import java.util.*;

public class EventAttendeeWelcome {
    public static void main(String[] args) {
        // List of attendees
        List<String> attendees = Arrays.asList("John", "Emma", "Sophia", "David", "Lily");

        System.out.println("Welcome Messages:");
        attendees.forEach(name -> System.out.println("Welcome, " + name + "! Enjoy the event."));
    }
}
