import java.util.*;

public class NthFromEndLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;

        String result = getNthFromEnd(list, n);
        System.out.println("Nth element from end: " + result);
    }

    public static String getNthFromEnd(LinkedList<String> list, int n) {
        Iterator<String> first = list.iterator();
        Iterator<String> second = list.iterator();
        for (int i = 0; i < n; i++) if (first.hasNext()) first.next();

        while (first.hasNext()) {
            first.next();
            second.next();
        }
        return second.next();
    }
}