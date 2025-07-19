public class MainNotification {
    public static void main(String[] args) {
        NotificationQueue queue = new NotificationQueue();
        queue.add(new EmailNotification("user@example.com", "Welcome to our service!"));
        queue.add(new SMSNotification("+911234567890", "Your OTP is 456789"));
        queue.add(new PushNotification("New feature released!"));

        queue.sendAll();
    }
}

interface Notification {
    void deliver();
}

class EmailNotification implements Notification {
    private String email;
    private String message;

    public EmailNotification(String email, String message) {
        this.email = email;
        this.message = message;
    }

    public void deliver() {
        System.out.println("Sending EMAIL to " + email + ": " + message);
    }
}

class SMSNotification implements Notification {
    private String phoneNumber;
    private String message;

    public SMSNotification(String phoneNumber, String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public void deliver() {
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}

class PushNotification implements Notification {
    private String message;

    public PushNotification(String message) {
        this.message = message;
    }

    public void deliver() {
        System.out.println("Sending PUSH notification: " + message);
    }
}

import java.util.LinkedList;

class NotificationQueue {
    private LinkedList<Notification> queue = new LinkedList<>();

    public void add(Notification notification) {
        queue.add(notification);
    }

    public void sendAll() {
        while (!queue.isEmpty()) {
            Notification notification = queue.removeFirst();
            notification.deliver();
        }
    }
}