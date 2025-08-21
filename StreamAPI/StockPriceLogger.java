import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {
        // Simulated live stock prices
        List<Double> stockPrices = Arrays.asList(125.50, 127.75, 124.20, 130.10, 129.80);

        System.out.println("Live Stock Price Updates:");
        stockPrices.forEach(price -> System.out.println("Stock Price: $" + price));
    }
}
