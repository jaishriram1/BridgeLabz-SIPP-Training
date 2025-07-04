public class OnlineTicketReservationSystem {
    static class Ticket {
        int id;
        String customer;
        String movie;
        String seat;
        String time;
        Ticket next;

        Ticket(int id, String customer, String movie, String seat, String time) {
            this.id = id;
            this.customer = customer;
            this.movie = movie;
            this.seat = seat;
            this.time = time;
        }
    }

    static Ticket head = null;

    public static void addTicket(int id, String customer, String movie, String seat, String time) {
        Ticket t = new Ticket(id, customer, movie, seat, time);
        if (head == null) {
            head = t;
            head.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = t;
            t.next = head;
        }
    }

    public static void displayTickets() {
        if (head == null) return;
        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.id + ", " + temp.customer + " booked " + temp.movie + " Seat: " + temp.seat + " at " + temp.time);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        addTicket(101, "Alice", "Inception", "A1", "10:00AM");
        addTicket(102, "Bob", "Avatar", "B2", "12:00PM");
        displayTickets();
    }
}
