import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;

        Collections.rotate(list, -rotateBy);
        System.out.println("Rotated List: " + list);
    }
}