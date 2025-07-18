import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SkillForgePortal {
    public static void main(String[] args) {
        Instructor techGuru = new Instructor("Dr. Ada Lovelace");
        Student learner = new Student("Charles Babbage");

        BeginnerCourse introToJava = new BeginnerCourse("Intro to Java", techGuru);
        AdvancedCourse dataStructures = new AdvancedCourse("Advanced Data Structures", techGuru, new String[]{"Arrays", "Stacks", "Trees", "Graphs"});
        
        techGuru.addCourse(introToJava);
        techGuru.addCourse(dataStructures);

        learner.enroll(introToJava);
        learner.enroll(dataStructures);

        System.out.println("--- Progress Tracking ---");
        learner.completeModule(introToJava);
        System.out.printf("%s's progress in '%s': %.0f%%\n", learner.name, introToJava.title, learner.getProgress(introToJava));

        System.out.println("\n--- Course Rating ---");
        System.out.printf("Initial rating for '%s': %.2f\n", introToJava.title, introToJava.getRating());
        introToJava.addRating(5);
        introToJava.addRating(4);
        System.out.printf("Rating after reviews: %.2f\n", introToJava.getRating());

        System.out.println("\n--- Certification ---");
        System.out.println(introToJava.generateCertificate(learner));
        System.out.println(dataStructures.generateCertificate(learner));

        System.out.println("\n--- Internal Data Access ---");
        List<String> reviews = dataStructures.getInternalCourseReviews();
        System.out.println("Internal reviews for '" + dataStructures.title + "': " + reviews);
    }
}

// ---

interface ICertifiable {
    String generateCertificate(Student student);
}

// ---

class User {
    String name;
    int userId;
    private static int userCount = 0;

    public User(String name) {
        this.name = name;
        this.userId = ++userCount;
    }
}

class Student extends User {
    private List<Course> enrolledCourses = new ArrayList<>();
    private List<Integer> modulesCompleted = new ArrayList<>();

    public Student(String name) {
        super(name);
    }

    public void enroll(Course course) {
        enrolledCourses.add(course);
        modulesCompleted.add(0);
    }

    public void completeModule(Course course) {
        int courseIndex = enrolledCourses.indexOf(course);
        if (courseIndex != -1) {
            int currentCompletions = modulesCompleted.get(courseIndex);
            modulesCompleted.set(courseIndex, currentCompletions + 1);
        }
    }

    public double getProgress(Course course) {
        int courseIndex = enrolledCourses.indexOf(course);
        if (courseIndex == -1 || course.modules.length == 0) return 0.0;
        return ((double) modulesCompleted.get(courseIndex) / course.modules.length) * 100.0;
    }
}

class Instructor extends User {
    private List<Course> coursesTaught = new ArrayList<>();

    public Instructor(String name) {
        super(name);
    }
    
    public void addCourse(Course course) {
        this.coursesTaught.add(course);
    }
}

// ---

abstract class Course implements ICertifiable {
    String title;
    Instructor instructor;
    String[] modules;
    private double rating;
    private int ratingCount;
    private final List<String> internalCourseReviews;

    public Course(String title, Instructor instructor) {
        this.title = title;
        this.instructor = instructor;
        this.modules = new String[]{"Introduction", "Core Concepts", "Final Project"};
        this.internalCourseReviews = new ArrayList<>(Arrays.asList("Initial peer review: Positive."));
    }

    public Course(String title, Instructor instructor, String[] modules) {
        this.title = title;
        this.instructor = instructor;
        this.modules = modules;
        this.internalCourseReviews = new ArrayList<>(Arrays.asList("Initial peer review: Positive."));
    }

    public void addRating(int newRating) {
        int validRating = Math.max(1, Math.min(5, newRating));
        double totalRating = this.rating * this.ratingCount;
        this.ratingCount++;
        this.rating = (totalRating + validRating) / this.ratingCount;
    }

    public double getRating() {
        return this.rating;
    }
    
    public List<String> getInternalCourseReviews() {
        return Collections.unmodifiableList(this.internalCourseReviews);
    }
}

class BeginnerCourse extends Course {
    public BeginnerCourse(String title, Instructor instructor) {
        super(title, instructor);
    }

    @Override
    public String generateCertificate(Student student) {
        return String.format("📜 CERTIFICATE OF COMPLETION for %s, awarded to %s.", title, student.name);
    }
}

class AdvancedCourse extends Course {
    public AdvancedCourse(String title, Instructor instructor, String[] modules) {
        super(title, instructor, modules);
    }

    @Override
    public String generateCertificate(Student student) {
        return String.format("🏆 CERTIFICATE OF ADVANCED ACHIEVEMENT in %s, proudly presented to %s by %s.", title, student.name, instructor.name);
    }
}