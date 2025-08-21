import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiMovies {

    public static void main(String[] args) {
        // Sample movie list
        List<Movie> movies = List.of(
            new Movie("Movie A", 8.5, 2023),
            new Movie("Movie B", 9.1, 2024),
            new Movie("Movie C", 8.9, 2023),
            new Movie("Movie D", 7.8, 2024),
            new Movie("Movie E", 9.2, 2023),
            new Movie("Movie F", 8.7, 2024),
            new Movie("Movie G", 9.5, 2022),
            new Movie("Movie H", 9.0, 2024)
        );

        // Find the top 5 trending movies
        List<Movie> top5Movies = findTop5TrendingMovies(movies);

        // Print the result
        System.out.println("Top 5 Trending Movies:");
        top5Movies.forEach(System.out::println);
    }

    public static List<Movie> findTop5TrendingMovies(List<Movie> movies) {
        return movies.stream()
                // Step 1: Filter movies with a rating greater than or equal to 8.0 (example filter)
                .filter(movie -> movie.getRating() >= 8.0)
                
                // Step 2: Sort movies first by release year (descending) and then by rating (descending)
                .sorted(Comparator.comparing(Movie::getReleaseYear).reversed()
                        .thenComparing(Movie::getRating).reversed())
                
                // Step 3: Limit the result to the top 5
                .limit(5)
                
                // Step 4: Collect the result into a new list
                .collect(Collectors.toList());
    }
}

class Movie {
    private String title;
    private double rating;
    private int releaseYear;

    public Movie(String title, double rating, int releaseYear) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return "Movie{" +
               "title='" + title + '\'' +
               ", rating=" + rating +
               ", releaseYear=" + releaseYear +
               '}';
    }
}