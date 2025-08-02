import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Alice", "1234567890");
        phoneBook.put("Bob", "9876543210");
        phoneBook.put("Charlie", "5555555555");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();

        if (phoneBook.containsKey(name)) {
            System.out.println("Phone Number: " + phoneBook.get(name));
        } else {
            System.out.println("Name not found in phone book.");
        }
        sc.close();
    }
}
