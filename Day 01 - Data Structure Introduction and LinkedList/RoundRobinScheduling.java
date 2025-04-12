import java.util.Scanner;

class Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnaroundTime = 0;
    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

class CircularLinkedList {
    private Process tail = null;

    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (tail == null) {
            tail = newProcess;
            tail.next = tail;
        } else {
            newProcess.next = tail.next;
            tail.next = newProcess;
            tail = newProcess;
        }
    }

    public void removeProcess(Process process) {
        if (tail == null || process == null) return;

        Process curr = tail;
        Process prev = null;
        do {
            prev = curr;
            curr = curr.next;
            if (curr == process) {
                if (curr == tail && curr.next == tail) {
                    tail = null; // Only one node
                } else {
                    if (curr == tail) {
                        tail = prev;
                    }
                    prev.next = curr.next;
                }
                return;
            }
        } while (curr != tail);
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public void simulateRoundRobin(int timeQuantum) {
        if (tail == null) return;

        Process current = tail.next;
        int currentTime = 0;
        int totalProcesses = countProcesses();

        while (!isEmpty()) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, current.remainingTime);
                System.out.println("Executing Process " + current.pid + " for " + execTime + " units.");
                current.remainingTime -= execTime;
                currentTime += execTime;

                // Update waiting and turnaround time for others
                Process temp = tail.next;
                do {
                    if (temp != current && temp.remainingTime > 0) {
                        temp.waitingTime += execTime;
                    }
                    temp = temp.next;
                } while (temp != tail.next);

                if (current.remainingTime == 0) {
                    current.turnaroundTime = currentTime;
                    System.out.println("Process " + current.pid + " completed.");
                    Process toRemove = current;
                    current = current.next;
                    removeProcess(toRemove);
                    displayProcesses();
                    continue;
                }
            }
            current = current.next;
        }

        // Final Report
        double totalWT = 0, totalTAT = 0;
        System.out.println("\nFinal Report:");
        Process temp = tail;
        if (temp != null) {
            do {
                temp = temp.next;
                System.out.println("Process ID: " + temp.pid +
                                   ", Waiting Time: " + temp.waitingTime +
                                   ", Turnaround Time: " + temp.turnaroundTime);
                totalWT += temp.waitingTime;
                totalTAT += temp.turnaroundTime;
            } while (temp != tail);
        }

        System.out.printf("Average Waiting Time: %.2f\n", totalWT / totalProcesses);
        System.out.printf("Average Turnaround Time: %.2f\n", totalTAT / totalProcesses);
    }

    public void displayProcesses() {
        if (tail == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = tail.next;
        System.out.println("Current Process Queue:");
        do {
            System.out.println("PID: " + temp.pid + ", Remaining Time: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != tail.next);
        System.out.println();
    }

    private int countProcesses() {
        if (tail == null) return 0;
        int count = 0;
        Process temp = tail.next;
        do {
            count++;
            temp = temp.next;
        } while (temp != tail.next);
        return count;
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        CircularLinkedList scheduler = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Process " + (i + 1));
            System.out.print("Process ID: ");
            int pid = sc.nextInt();
            System.out.print("Burst Time: ");
            int bt = sc.nextInt();
            System.out.print("Priority: ");
            int pr = sc.nextInt();
            scheduler.addProcess(pid, bt, pr);
        }

        System.out.print("Enter Time Quantum: ");
        int tq = sc.nextInt();

        System.out.println("\n--- Starting Round Robin Scheduling ---\n");
        scheduler.displayProcesses();
        scheduler.simulateRoundRobin(tq);
    }
}
