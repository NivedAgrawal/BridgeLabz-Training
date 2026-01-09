package linkedlist;

class Node {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnAroundTime;

    Node next;

    public Node(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}
class RoundRobinScheduler {
    private Node head = null;
    private int timeQuantum;
    private int currentTime = 0;
    private int processCount = 0;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int pid, int burstTime, int priority) {
        Node newNode = new Node(pid, burstTime, priority);
        processCount++;

        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    private void removeProcess(Node prev, Node curr) {
        if (curr == head && curr.next == head) {
            head = null;
        } else {
            prev.next = curr.next;
            if (curr == head) {
                head = curr.next;
            }
        }
    }

 
    public void displayQueue() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }

        Node temp = head;
        System.out.print("Processes: ");
        do {
            System.out.print("[P" + temp.pid + " RT:" + temp.remainingTime + "] ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public void simulate() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        Node curr = head;
        Node prev = null;

        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int completed = 0;

        while (head != null) {
            displayQueue();

            if (curr.remainingTime > timeQuantum) {
                curr.remainingTime -= timeQuantum;
                currentTime += timeQuantum;
            } else {
                currentTime += curr.remainingTime;
                curr.remainingTime = 0;

                curr.turnAroundTime = currentTime;
                curr.waitingTime = curr.turnAroundTime - curr.burstTime;

                totalWaitingTime += curr.waitingTime;
                totalTurnAroundTime += curr.turnAroundTime;
                completed++;

                removeProcess(prev, curr);
            }

            prev = curr;
            curr = curr.next;
        }

        System.out.println("\n All processes completed.");
        System.out.println("Average Waiting Time = " +
                (double) totalWaitingTime / completed);
        System.out.println("Average Turnaround Time = " +
                (double) totalTurnAroundTime / completed);
    }
}
public class RoundRobinAlgorithm {
    public static void main(String[] args) {

        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);

        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);

        scheduler.simulate();
    }
}
