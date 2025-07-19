public class MainJob {
    public static void main(String[] args) {
        JobQueue queue = new JobQueue();
        queue.add(new DataSyncJob());
        queue.add(new EmailAlertJob());
        queue.add(new CleanupJob());

        queue.executeAll();
    }
}

interface Executable {
    void execute();
}

class DataSyncJob implements Executable {
    public void execute() {
        System.out.println("Executing Data Sync Job...");
    }
}

class EmailAlertJob implements Executable {
    public void execute() {
        System.out.println("Executing Email Alert Job...");
    }
}

class CleanupJob implements Executable {
    public void execute() {
        System.out.println("Executing Cleanup Job...");
    }
}

import java.util.LinkedList;

class JobQueue {
    private LinkedList<Executable> jobs = new LinkedList<>();

    public void add(Executable job) {
        jobs.add(job);
    }

    public void executeAll() {
        while (!jobs.isEmpty()) {
            jobs.removeFirst().execute();
        }
    }
}