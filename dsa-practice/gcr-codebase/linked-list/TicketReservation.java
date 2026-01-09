package linkedlist;

class Node {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;

    Node next;

    public Node(int ticketId, String customerName,
                      String movieName, String seatNumber,
                      String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}
class TicketReservationSystem {
    private Node head = null;
    public void addTicket(int id, String customer, String movie,
                          String seat, String time) {

        Node newTicket = new Node(id, customer, movie, seat, time);

        if (head == null) {
            head = newTicket;
            head.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newTicket;
        newTicket.next = head;
    }
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println(" No tickets booked.");
            return;
        }

        Node curr = head;
        Node prev = null;

        do {
            if (curr.ticketId == ticketId) {
                if (curr == head && curr.next == head) {
                    head = null;
                }
                else if (curr == head) {
                    Node last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                }
                else {
                    prev.next = curr.next;
                }

                System.out.println("✅ Ticket " + ticketId + " removed.");
                return;
            }

            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Ticket ID not found.");
    }
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Node temp = head;
        System.out.println("Booked Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketId +
                    ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName +
                    ", Seat: " + temp.seatNumber +
                    ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Node temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(keyword) ||
                temp.movieName.equalsIgnoreCase(keyword)) {

                System.out.println("Found → Ticket ID: " + temp.ticketId +
                        ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName +
                        ", Seat: " + temp.seatNumber);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No matching ticket found.");
        }
    }

    public int countTickets() {
        if (head == null) return 0;

        int count = 0;
        Node temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
}
public class TicketReservation {
    public static void main(String[] args) {

        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Rahul", "Avengers", "A10", "10:00 AM");
        system.addTicket(102, "Priya", "Inception", "B12", "12:30 PM");
        system.addTicket(103, "Amit", "Avengers", "C05", "03:00 PM");

        system.displayTickets();

        system.searchTicket("Avengers");
        system.removeTicket(102);

        system.displayTickets();

        System.out.println("\n🎫 Total Tickets Booked: " +
                system.countTickets());
    }
}

