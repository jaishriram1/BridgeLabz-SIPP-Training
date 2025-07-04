public class LibraryManagementSystem {
    static class Book {
        String title;
        String author;
        String genre;
        int bookId;
        boolean available;
        Book prev, next;

        Book(String title, String author, String genre, int bookId, boolean available) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.available = available;
        }
    }

    static Book head = null, tail = null;

    public static void addBook(String title, String author, String genre, int id, boolean available) {
        Book book = new Book(title, author, genre, id, available);
        if (head == null) {
            head = tail = book;
        } else {
            tail.next = book;
            book.prev = tail;
            tail = book;
        }
    }

    public static void displayBooks() {
        Book temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + ", " + temp.title + " by " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.available);
            temp = temp.next;
        }
    }

    public static int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void updateAvailability(int bookId, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.available = status;
                return;
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        addBook("Java Basics", "John Doe", "Programming", 1, true);
        addBook("DSA", "Alice", "Computer", 2, false);
        displayBooks();
        System.out.println("Total books: " + countBooks());
        updateAvailability(2, true);
        System.out.println("After updating availability:");
        displayBooks();
    }
}
