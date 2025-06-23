public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void addItem(int qty) {
        quantity += qty;
        System.out.println(qty + " items added.");
    }

    public void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println(qty + " items removed.");
        } else {
            System.out.println("Cannot remove more than present quantity!");
        }
    }

    public void displayTotalCost() {
        double total = price * quantity;
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price per item: ₹" + price);
        System.out.println("Total Cost: ₹" + total);
    }

    public static void main(String[] args) {
        CartItem item = new CartItem("Laptop", 50000, 1);
        item.displayTotalCost();
        item.addItem(1);
        item.displayTotalCost();
        item.removeItem(1);
        item.displayTotalCost();
    }
}