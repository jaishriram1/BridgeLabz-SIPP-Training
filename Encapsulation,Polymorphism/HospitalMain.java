abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
}

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private String record;

    public InPatient(String id, String name, int age) {
        super(id, name, age);
    }

    public double calculateBill() {
        return 10000;
    }

    public void addRecord(String r) {
        record = r;
    }

    public void viewRecords() {
        System.out.println("Record: " + record);
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private String record;

    public OutPatient(String id, String name, int age) {
        super(id, name, age);
    }

    public double calculateBill() {
        return 500;
    }

    public void addRecord(String r) {
        record = r;
    }

    public void viewRecords() {
        System.out.println("Record: " + record);
    }
}

public class HospitalMain {
    public static void main(String[] args) {
        Patient p1 = new InPatient("P001", "John", 30);
        Patient p2 = new OutPatient("P002", "Mary", 25);

        MedicalRecord r1 = (MedicalRecord) p1;
        MedicalRecord r2 = (MedicalRecord) p2;

        r1.addRecord("Surgery");
        r2.addRecord("Fever");

        Patient[] patients = { p1, p2 };

        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Bill: ₹" + p.calculateBill());
            ((MedicalRecord)p).viewRecords();
            System.out.println();
        }
    }
}
