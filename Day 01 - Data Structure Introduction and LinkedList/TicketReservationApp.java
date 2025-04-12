import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
}

class TicketReservationSystem {
    private Ticket tail = null;

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (tail == null) {
            tail = newTicket;
            tail.next = tail;
        } else {
            newTicket.next = tail.next;
            tail.next = newTicket;
            tail = newTicket;
        }
        System.out.println("Ticket booked successfully.");
    }

    public void removeTicket(int ticketId) {
        if (tail == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket curr = tail.next, prev = tail;
        do {
            if (curr.ticketId == ticketId) {
                if (curr == tail && curr.next == tail) {
                    tail = null; // only one ticket
                } else {
                    if (curr == tail) tail = prev;
                    prev.next = curr.next;
                }
                System.out.println("Ticket ID " + ticketId + " removed.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != tail.next);

        System.out.println("Ticket ID " + ticketId + " not found.");
    }

    public void displayTickets() {
        if (tail == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = tail.next;
        System.out.println("Booked Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketId +
                    ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName +
                    ", Seat: " + temp.seatNumber +
                    ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != tail.next);
    }

    public void searchByCustomerOrMovie(String keyword) {
        if (tail == null) {
            System.out.println("No tickets to search.");
            return;
        }

        boolean found = false;
        Ticket temp = tail.next;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID: " + temp.ticketId +
                        ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName +
                        ", Seat: " + temp.seatNumber +
                        ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != tail.next);

        if (!found) System.out.println("No matching tickets found.");
    }

    public void countTickets() {
        if (tail == null) {
            System.out.println("Total booked tickets: 0");
            return;
        }

        int count = 0;
        Ticket temp = tail.next;
        do {
            count++;
            temp = temp.next;
        } while (temp != tail.next);

        System.out.println("Total booked tickets: " + count);
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();

        while (true) {
            System.out.println("\n--- Online Ticket Reservation ---");
            System.out.println("1. Book New Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search by Customer Name or Movie");
            System.out.println("5. Count Booked Tickets");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Booking Time: ");
                    String time = sc.nextLine();
                    system.addTicket(id, name, movie, seat, time);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    int tid = sc.nextInt();
                    system.removeTicket(tid);
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer Name or Movie Name: ");
                    String keyword = sc.nextLine();
                    system.searchByCustomerOrMovie(keyword);
                    break;

                case 5:
                    system.countTickets();
                    break;

                case 6:
                    System.out.println("Exiting.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
