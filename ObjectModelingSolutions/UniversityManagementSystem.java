import java.util.*;

class Professor {
    String name;
    Professor(String name) {
        this.name = name;
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enrollCourse(Course c) {
        courses.add(c);
        c.addStudent(this);
    }
}

class Course {
    String title;
    Professor professor;
    List<Student> students = new ArrayList<>();

    Course(String title) {
        this.title = title;
    }

    void assignProfessor(Professor p) {
        this.professor = p;
    }

    void addStudent(Student s) {
        students.add(s);
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Professor prof = new Professor("Dr. Sharma");
        Course c = new Course("Data Structures");
        c.assignProfessor(prof);

        Student s = new Student("Rahul");
        s.enrollCourse(c);

        System.out.println(s.name + " enrolled in " + c.title + " taught by " + c.professor.name);
    }
}
