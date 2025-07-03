abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println(itemName + " | ₹" + price + " x " + quantity);
    }
}

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double applyDiscount() {
        return 0.05 * calculateTotalPrice();
    }

    public String getDiscountDetails() {
        return "5% discount on Veg";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + 20; // extra charge
    }

    public double applyDiscount() {
        return 0.02 * calculateTotalPrice();
    }

    public String getDiscountDetails() {
        return "2% discount on Non-Veg";
    }
}

public class FoodDeliveryMain {
    public static void main(String[] args) {
        FoodItem[] order = {
            new VegItem("Paneer", 150, 2),
            new NonVegItem("Chicken", 200, 1)
        };

        for (FoodItem item : order) {
            item.getItemDetails();
            double total = item.calculateTotalPrice();
            Discountable disc = (Discountable) item;
            double discount = disc.applyDiscount();
            System.out.println("Total: ₹" + total);
            System.out.println("Discount: ₹" + discount);
            System.out.println("Final: ₹" + (total - discount));
            System.out.println(disc.getDiscountDetails());
            System.out.println();
        }
    }
}
