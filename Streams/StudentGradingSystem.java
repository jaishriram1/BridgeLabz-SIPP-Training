import java.util.*;
public class StudentGradingSystem {
    static class Student {
        String name;
        String id;
        Integer[] grades;
        Student(String name, String id, int subjects) {
            this.name = name;
            this.id = id;
            this.grades = new Integer[subjects];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numStudents, numSubjects;

        System.out.print("Enter number of students: ");
        numStudents = sc.nextInt();

        System.out.print("Enter number of subjects: ");
        numSubjects = sc.nextInt();

        Student[] students = new Student[numStudents];

        // Input student data
        for (int i = 0; i < numStudents; i++) {
            sc.nextLine(); // consume leftover newline
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("ID: ");
            String id = sc.nextLine();
            students[i] = new Student(name, id, numSubjects);

            for (int j = 0; j < numSubjects; j++) {
                try {
                    System.out.print("Enter grade for Subject " + (j + 1) + " (0-100): ");
                    String input = sc.nextLine();
                    if (input.trim().isEmpty()) {
                        students[i].grades[j] = null; // missing
                    } else {
                        int grade = Integer.parseInt(input);
                        if (grade < 0 || grade > 100) throw new IllegalArgumentException("Grade must be 0–100");
                        students[i].grades[j] = grade;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Grade set as missing.");
                    students[i].grades[j] = null;
                }
            }
        }

        // Student total and average
        System.out.println("\n=== Student Totals and Averages ===");
        for (Student student : students) {
            int sum = 0, count = 0;
            for (Integer grade : student.grades) {
                if (grade != null) {
                    sum += grade;
                    count++;
                }
            }
            double avg = count > 0 ? (double) sum / count : 0;
            System.out.println(student.name + " (ID: " + student.id + ") → Total: " + sum + ", Average: " + String.format("%.2f", avg));
        }

        // Highest grade in each subject
        System.out.println("\n=== Highest Grade Per Subject ===");
        for (int j = 0; j < numSubjects; j++) {
            int max = -1;
            for (Student student : students) {
                if (student.grades[j] != null && student.grades[j] > max) {
                    max = student.grades[j];
                }
            }
            System.out.println("Subject " + (j + 1) + " → Highest Grade: " + (max >= 0 ? max : "No valid entries"));
        }

        // Class average
        int totalSum = 0, totalCount = 0;
        for (Student student : students) {
            for (Integer grade : student.grades) {
                if (grade != null) {
                    totalSum += grade;
                    totalCount++;
                }
            }
        }
        double classAvg = totalCount > 0 ? (double) totalSum / totalCount : 0;
        System.out.println("\n=== Class Average: " + String.format("%.2f", classAvg) + " ===");

        sc.close();
    }
}