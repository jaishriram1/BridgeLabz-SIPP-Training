public class InventoryManagementSystem {
    static class Item {
        String name;
        int id;
        int quantity;
        double price;
        Item next;

        Item(String name, int id, int quantity, double price) {
            this.name = name;
            this.id = id;
            this.quantity = quantity;
            this.price = price;
        }
    }

    static Item head = null;

    public static void addItem(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newItem;
        }
    }

    public static void displayItems() {
        Item temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Qty: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    public static double totalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        return total;
    }

    public static void main(String[] args) {
        addItem("Mouse", 101, 10, 250.5);
        addItem("Keyboard", 102, 5, 500.0);
        displayItems();
        System.out.println("Total Inventory Value: Rs. " + totalValue());
    }
}
