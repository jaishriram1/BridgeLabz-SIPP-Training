import java.io.*;

public class FileReadingComparison {
    public static void main(String[] args) {
        String filePath = "largefile.txt";

        try {
            long start = System.nanoTime();
            FileReader fr = new FileReader(filePath);
            while (fr.read() != -1);
            fr.close();
            long end = System.nanoTime();
            System.out.println("FileReader time: " + (end - start) / 1e6 + " ms");

            start = System.nanoTime();
            InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
            while (isr.read() != -1);
            isr.close();
            end = System.nanoTime();
            System.out.println("InputStreamReader time: " + (end - start) / 1e6 + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}