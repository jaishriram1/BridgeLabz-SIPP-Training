import java.util.*;

class Book {
    String title, author;
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

class Library {
    String name;
    List<Book> books = new ArrayList<>();
    
    Library(String name) {
        this.name = name;
    }
    
    void addBook(Book book) {
        books.add(book);
    }
    
    void showBooks() {
        System.out.println("Books in " + name + ":");
        for (Book b : books) {
            System.out.println("- " + b.title + " by " + b.author);
        }
    }
}

public class LibraryBooksAggregation {
    public static void main(String[] args) {
        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("To Kill a Mockingbird", "Harper Lee");

        Library lib1 = new Library("City Library");
        Library lib2 = new Library("School Library");

        lib1.addBook(b1);
        lib2.addBook(b1);
        lib1.addBook(b2);

        lib1.showBooks();
        lib2.showBooks();
    }
}
