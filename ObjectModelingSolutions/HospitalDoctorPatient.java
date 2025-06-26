import java.util.*;

class Patient {
    String name;
    Patient(String name) {
        this.name = name;
    }
}

class Doctor {
    String name;
    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient p) {
        System.out.println("Dr. " + name + " is consulting patient " + p.name);
    }
}

public class HospitalDoctorPatient {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("Smith");
        Patient p1 = new Patient("John");
        Patient p2 = new Patient("Emily");

        d1.consult(p1);
        d1.consult(p2);
    }
}
