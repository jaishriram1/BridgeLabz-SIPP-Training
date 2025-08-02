import java.util.Arrays;

public class CircularBuffer {
    private int[] buffer;
    private int size;
    private int start;
    private int count;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = capacity;
        start = 0;
        count = 0;
    }

    public void insert(int value) {
        int index = (start + count) % size;
        buffer[index] = value;
        if (count < size) {
            count++;
        } else {
            start = (start + 1) % size; // Overwrite oldest
        }
    }

    public void printBuffer() {
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(start + i) % size] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.printBuffer(); // 1 2 3
        cb.insert(4);
        cb.printBuffer(); // 2 3 4
    }
}
