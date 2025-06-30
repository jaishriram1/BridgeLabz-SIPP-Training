import java.util.*;

class Product {
    private String name;
    private String category;
    private int price;
    private int quantity;

    public Product(String name, String category, int price, int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getPrice() { return price; }
    public int getQuantity() { return quantity; }

    // Setters
    public void setPrice(int price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "Name: " + name + ", Category: " + category + ", Price: " + price + ", Quantity: " + quantity;
    }
}

class ProductCatalog {
    private List<Product> products = new ArrayList<>();
    private final int MAX_STOCK = 1000;

    // Add new product
    public void addProduct(String name, String category, int price, int quantity) {
        products.add(new Product(name, category, price, quantity));
    }

    // Search by name
    public Product searchByName(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // Search by category
    public List<Product> searchByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                result.add(p);
            }
        }
        return result;
    }

    // Update product stock
    public void updateStock(String name, int newQuantity) throws Exception {
        Product p = searchByName(name);
        if (p == null) {
            throw new Exception("Product not found.");
        }
        if (newQuantity < 0 || newQuantity > MAX_STOCK) {
            throw new Exception("Invalid stock quantity (must be 0-" + MAX_STOCK + ").");
        }
        p.setQuantity(newQuantity);
    }

    // Generate report sorted by price
    public void generateReport(boolean ascending) {
        List<Product> sortedList = new ArrayList<>(products);
        sortedList.sort((p1, p2) -> ascending ? p1.getPrice() - p2.getPrice() : p2.getPrice() - p1.getPrice());
        System.out.println("---- Product Report ----");
        for (Product p : sortedList) {
            System.out.println(p);
        }
    }
}

public class ECommerce {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        // Sample interaction
        catalog.addProduct("iPhone", "Electronics", 70000, 50);
        catalog.addProduct("T-shirt", "Clothing", 500, 200);
        catalog.addProduct("Shoes", "Footwear", 1500, 100);
        catalog.addProduct("MacBook", "Electronics", 150000, 20);

        try {
            catalog.updateStock("iPhone", 55); // valid
            catalog.updateStock("T-shirt", 1500); // invalid: exceeds max
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        Product found = catalog.searchByName("MacBook");
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("\nProducts in category 'Electronics':");
        List<Product> electronics = catalog.searchByCategory("Electronics");
        for (Product p : electronics) {
            System.out.println(p);
        }

        System.out.println("\nSorted Report (ascending):");
        catalog.generateReport(true);

        System.out.println("\nSorted Report (descending):");
        catalog.generateReport(false);
    }
}
