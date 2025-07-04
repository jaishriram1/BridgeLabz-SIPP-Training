public class StudentRecordManagement {
    static class Student {
        int rollNumber;
        String name;
        int age;
        char grade;
        Student next;

        Student(int rollNumber, String name, int age, char grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    static Student head = null;

    public static void addStudentAtEnd(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public static void deleteStudentByRoll(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public static Student searchByRoll(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public static void updateGrade(int rollNumber, char newGrade) {
        Student s = searchByRoll(rollNumber);
        if (s != null) s.grade = newGrade;
    }

    public static void displayAll() {
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + ", Name: " + temp.name +
                ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        addStudentAtEnd(1, "Alice", 20, 'A');
        addStudentAtEnd(2, "Bob", 21, 'B');
        displayAll();
        System.out.println("Updating grade of Roll 2 to A");
        updateGrade(2, 'A');
        displayAll();
        System.out.println("Deleting Roll 1");
        deleteStudentByRoll(1);
        displayAll();
    }
}
