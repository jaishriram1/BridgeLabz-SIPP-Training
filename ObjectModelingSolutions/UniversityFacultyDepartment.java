import java.util.*;

class Faculty {
    String name;
    Faculty(String name) {
        this.name = name;
    }
}

class Department {
    String name;
    Department(String name) {
        this.name = name;
    }
}

class University {
    String name;
    List<Department> departments = new ArrayList<>();

    University(String name) {
        this.name = name;
    }

    void addDepartment(String name) {
        departments.add(new Department(name));
    }

    void showDepartments() {
        for (Department d : departments) {
            System.out.println("- " + d.name);
        }
    }
}

public class UniversityFacultyDepartment {
    public static void main(String[] args) {
        University u = new University("XYZ University");

        u.addDepartment("CSE");
        u.addDepartment("ECE");

        Faculty f1 = new Faculty("Dr. Raj");
        Faculty f2 = new Faculty("Dr. Meena");

        System.out.println("University Departments:");
        u.showDepartments();
        System.out.println("Independent Faculties:");
        System.out.println("- " + f1.name);
        System.out.println("- " + f2.name);
    }
}
