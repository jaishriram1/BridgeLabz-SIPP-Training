import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String source = "largefile.dat";
        String destBuffered = "copy_buffered.dat";
        String destUnbuffered = "copy_unbuffered.dat";

        copyWithBufferedStreams(source, destBuffered);
        copyWithUnbufferedStreams(source, destUnbuffered);
    }

    private static void copyWithBufferedStreams(String source, String dest) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] buffer = new byte[4096];
            long start = System.nanoTime();
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            long end = System.nanoTime();
            System.out.println("Buffered copy took: " + (end - start)/1e6 + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyWithUnbufferedStreams(String source, String dest) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            byte[] buffer = new byte[4096];
            long start = System.nanoTime();
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            long end = System.nanoTime();
            System.out.println("Unbuffered copy took: " + (end - start)/1e6 + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}