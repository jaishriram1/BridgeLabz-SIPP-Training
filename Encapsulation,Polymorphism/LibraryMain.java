abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public int getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean available = true;

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem() {
        available = false;
    }

    public boolean checkAvailability() {
        return available;
    }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean available = true;

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem() {
        available = false;
    }

    public boolean checkAvailability() {
        return available;
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean available = true;

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem() {
        available = false;
    }

    public boolean checkAvailability() {
        return available;
    }
}

public class LibraryMain {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book(1, "Java Basics", "Author A"),
            new Magazine(2, "Tech Monthly", "Author B"),
            new DVD(3, "Inception", "Director C")
        };

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            Reservable res = (Reservable) item;
            System.out.println("Available: " + res.checkAvailability());
            res.reserveItem();
            System.out.println("Reserved. Available Now? " + res.checkAvailability());
            System.out.println();
        }
    }
}
