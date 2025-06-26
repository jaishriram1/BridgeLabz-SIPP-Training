import java.util.*;

class Product {
    String name;
    double price;
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    List<Product> products = new ArrayList<>();
    
    void addProduct(Product p) {
        products.add(p);
    }

    double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }
}

class Customer {
    String name;
    Customer(String name) {
        this.name = name;
    }

    void placeOrder(Order o) {
        System.out.println(name + " placed an order. Total: $" + o.calculateTotal());
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Customer c = new Customer("Amit");
        Product p1 = new Product("Phone", 700);
        Product p2 = new Product("Charger", 50);

        Order order = new Order();
        order.addProduct(p1);
        order.addProduct(p2);

        c.placeOrder(order);
    }
}
