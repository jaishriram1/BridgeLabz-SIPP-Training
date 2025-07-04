public class TaskScheduler {
    static class Task {
        int id;
        String name;
        int priority;
        String dueDate;
        Task next;

        Task(int id, String name, int priority, String dueDate) {
            this.id = id;
            this.name = name;
            this.priority = priority;
            this.dueDate = dueDate;
        }
    }

    static Task head = null;

    public static void addTask(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public static void displayTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println(temp.id + ": " + temp.name + " [" + temp.priority + "] Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        addTask(1, "Task A", 1, "2025-07-10");
        addTask(2, "Task B", 2, "2025-07-12");
        addTask(3, "Task C", 1, "2025-07-14");
        displayTasks();
    }
}
