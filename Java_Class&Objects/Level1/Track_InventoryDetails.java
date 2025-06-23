public class Item {
    private int itemCode;
    private String itemName;
    private double price;

    public Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public void displayDetails(int quantity) {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Unit Price: Rs." + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: Rs." + (price * quantity));
    }

    public static void main(String[] args) {
        Item item = new Item(501, "Notebook", 50);
        item.displayDetails(10);
    }
}
