import java.time.LocalDateTime;
import java.util.*;

public class LoggingTransactions {
    public static void main(String[] args) {
        // Sample list of transaction IDs
        List<String> transactionIds = Arrays.asList(
            "TXN001",
            "TXN002",
            "TXN003",
            "TXN004"
        );

        // Log each transaction with current timestamp
        transactionIds.forEach(id ->
            System.out.println(LocalDateTime.now() + " - Transaction: " + id)
        );
    }
}
