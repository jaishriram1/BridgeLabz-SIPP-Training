import java.util.*;

class Employee {
    String name;
    Employee(String name) {
        this.name = name;
    }
}

class Department {
    String name;
    List<Employee> employees = new ArrayList<>();
    
    Department(String name) {
        this.name = name;
    }
    
    void addEmployee(String name) {
        employees.add(new Employee(name));
    }

    void showEmployees() {
        System.out.println("Department: " + name);
        for (Employee e : employees) {
            System.out.println(" - " + e.name);
        }
    }
}

class Company {
    String name;
    List<Department> departments = new ArrayList<>();

    Company(String name) {
        this.name = name;
    }

    void addDepartment(String name) {
        departments.add(new Department(name));
    }

    void showAll() {
        System.out.println("Company: " + name);
        for (Department d : departments) {
            d.showEmployees();
        }
    }
}

public class CompanyDepartmentComposition {
    public static void main(String[] args) {
        Company c = new Company("TechCorp");
        c.addDepartment("HR");
        c.addDepartment("IT");
        c.departments.get(0).addEmployee("Alice");
        c.departments.get(1).addEmployee("Bob");

        c.showAll();
    }
}
