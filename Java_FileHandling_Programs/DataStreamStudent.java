import java.io.*;

public class DataStreamStudent {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("student.dat"))) {
            dos.writeInt(101);
            dos.writeUTF("John");
            dos.writeDouble(3.9);
            System.out.println("Data written.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("student.dat"))) {
            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();
            System.out.println("Read student: " + roll + " " + name + " " + gpa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}