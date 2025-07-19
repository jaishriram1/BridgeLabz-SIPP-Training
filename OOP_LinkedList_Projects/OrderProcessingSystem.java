public class MainOrder {
    public static void main(String[] args) {
        OrderQueue queue = new OrderQueue();
        queue.add(new OnlineOrder("Order#1234"));
        queue.add(new OfflineOrder("Order#5678"));
        queue.add(new SubscriptionOrder("Order#9999"));

        queue.processAll();
    }
}

interface Order {
    void process();
}

class OnlineOrder implements Order {
    private String orderId;

    public OnlineOrder(String orderId) {
        this.orderId = orderId;
    }

    public void process() {
        System.out.println("Processing ONLINE order: " + orderId);
    }
}

class OfflineOrder implements Order {
    private String orderId;

    public OfflineOrder(String orderId) {
        this.orderId = orderId;
    }

    public void process() {
        System.out.println("Processing OFFLINE order: " + orderId);
    }
}

class SubscriptionOrder implements Order {
    private String orderId;

    public SubscriptionOrder(String orderId) {
        this.orderId = orderId;
    }

    public void process() {
        System.out.println("Processing SUBSCRIPTION order: " + orderId);
    }
}

import java.util.LinkedList;

class OrderQueue {
    private LinkedList<Order> orders = new LinkedList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public void processAll() {
        while (!orders.isEmpty()) {
            orders.removeFirst().process();
        }
    }
}