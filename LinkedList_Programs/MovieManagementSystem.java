public class MovieManagementSystem {
    static class Movie {
        String title;
        String director;
        int year;
        double rating;
        Movie prev, next;

        Movie(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
        }
    }

    static Movie head = null, tail = null;

    public static void addMovieToEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public static void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " (" + temp.year + ") - " + temp.director + " - Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public static void displayBackward() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " (" + temp.year + ") - " + temp.director + " - Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void removeMovieByTitle(String title) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                if (temp == head) head = temp.next;
                if (temp == tail) tail = temp.prev;
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                break;
            }
            temp = temp.next;
        }
    }

    public static void updateRating(String title, double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = rating;
                break;
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        addMovieToEnd("Inception", "Nolan", 2010, 8.8);
        addMovieToEnd("Avatar", "Cameron", 2009, 7.9);
        displayForward();
        System.out.println("Updating rating...");
        updateRating("Avatar", 9.0);
        displayForward();
        System.out.println("Reverse order:");
        displayBackward();
        System.out.println("Removing Inception...");
        removeMovieByTitle("Inception");
        displayForward();
    }
}
