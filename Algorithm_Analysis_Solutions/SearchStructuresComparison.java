import java.util.*;

public class SearchStructuresComparison {
    public static void main(String[] args) {
        int N = 1000000;
        int[] array = new int[N];
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        int target = N - 1;

        long start = System.nanoTime();
        for (int i : array) {
            if (i == target) break;
        }
        long end = System.nanoTime();
        System.out.println("Array Search Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) / 1e6 + " ms");
    }
}