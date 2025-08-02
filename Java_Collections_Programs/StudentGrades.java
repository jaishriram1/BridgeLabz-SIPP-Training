import java.util.*;

public class StudentGrades {
    public static void main(String[] args) {
        TreeMap<String, Double> grades = new TreeMap<>();
        grades.put("Alice", 89.5);
        grades.put("Bob", 92.0);
        grades.put("Charlie", 78.3);

        for (Map.Entry<String, Double> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
