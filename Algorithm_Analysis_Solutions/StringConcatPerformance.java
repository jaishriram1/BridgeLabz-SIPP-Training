public class StringConcatPerformance {
    public static void main(String[] args) {
        int N = 10000;

        long start = System.nanoTime();
        String result = "";
        for (int i = 0; i < N; i++) result += "a";
        long end = System.nanoTime();
        System.out.println("String time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append("a");
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) sbf.append("a");
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start) / 1e6 + " ms");
    }
}