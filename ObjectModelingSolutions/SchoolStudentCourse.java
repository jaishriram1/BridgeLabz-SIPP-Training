import java.util.*;

class Course {
    String name;
    List<Student> enrolledStudents = new ArrayList<>();

    Course(String name) {
        this.name = name;
    }

    void addStudent(Student s) {
        enrolledStudents.add(s);
    }

    void showStudents() {
        System.out.println("Course: " + name);
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.name);
        }
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enroll(Course c) {
        courses.add(c);
        c.addStudent(this);
    }

    void showCourses() {
        System.out.println("Student: " + name);
        for (Course c : courses) {
            System.out.println("- " + c.name);
        }
    }
}

class School {
    String name;
    List<Student> students = new ArrayList<>();

    School(String name) {
        this.name = name;
    }

    void addStudent(Student s) {
        students.add(s);
    }
}

public class SchoolStudentCourse {
    public static void main(String[] args) {
        School school = new School("Greenwood High");

        Student s1 = new Student("Arjun");
        Student s2 = new Student("Riya");

        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        school.addStudent(s1);
        school.addStudent(s2);

        s1.enroll(c1);
        s2.enroll(c1);
        s2.enroll(c2);

        s1.showCourses();
        c1.showStudents();
    }
}
