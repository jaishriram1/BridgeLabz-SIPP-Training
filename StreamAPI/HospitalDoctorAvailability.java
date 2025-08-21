import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HospitalDoctorAvailability {

    public static void main(String[] args) {
        List<Doctor> doctors = List.of(
            new Doctor("Dr. Smith", "Cardiology", true),
            new Doctor("Dr. Jones", "Pediatrics", false),
            new Doctor("Dr. Lee", "Neurology", true),
            new Doctor("Dr. Garcia", "Cardiology", false),
            new Doctor("Dr. Chen", "Orthopedics", true),
            new Doctor("Dr. Kim", "Pediatrics", true)
        );

        // Find and sort the doctors
        List<Doctor> weekendDoctors = findWeekendDoctors(doctors);

        // Print the result
        System.out.println("Weekend Doctors, sorted by specialty:");
        weekendDoctors.forEach(System.out::println);
    }

    /**
     * Finds doctors available on weekends and sorts them by specialty.
     *
     * @param allDoctors A list of all doctors.
     * @return A list of doctors available on weekends, sorted by specialty.
     */
    public static List<Doctor> findWeekendDoctors(List<Doctor> allDoctors) {
        return allDoctors.stream()
                // Step 1: Filter the list to include only doctors available on weekends.
                .filter(Doctor::isWeekendAvailability)
                
                // Step 2: Sort the filtered list based on the doctor's specialty.
                .sorted(Comparator.comparing(Doctor::getSpecialty))
                
                // Step 3: Collect the results into a new list.
                .collect(Collectors.toList());
    }
}

class Doctor {
    private String name;
    private String specialty;
    private boolean weekendAvailability;

    public Doctor(String name, String specialty, boolean weekendAvailability) {
        this.name = name;
        this.specialty = specialty;
        this.weekendAvailability = weekendAvailability;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public boolean isWeekendAvailability() {
        return weekendAvailability;
    }

    @Override
    public String toString() {
        return "Doctor{" +
               "name='" + name + '\'' +
               ", specialty='" + specialty + '\'' +
               '}';
    }
}