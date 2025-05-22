class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    public Ticket(int ticketNumber, String customerName, int seatNumber) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String toString() {
        return "Ticket No: " + ticketNumber +
               ", Customer: " + customerName +
               ", Seat No: " + seatNumber;
    }
}

class BookingSystem {
    private Ticket[] tickets;
    private int ticketCount;

    public BookingSystem() {
        tickets = new Ticket[10]; // Max 10 seats
        ticketCount = 0;
    }

    private boolean isSeatTaken(int seatNumber) {
        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].getSeatNumber() == seatNumber) {
                return true;
            }
        }
        return false;
    }

    public void bookTicket(int ticketNumber, String customerName, int seatNumber) {
        if (ticketCount >= 10) {
            System.out.println("All seats are booked. Booking failed.");
            return;
        }
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number. Seat numbers must be between 1 and 10.");
            return;
        }
        if (isSeatTaken(seatNumber)) {
            System.out.println("Seat " + seatNumber + " is already booked.");
            return;
        }

        tickets[ticketCount++] = new Ticket(ticketNumber, customerName, seatNumber);
        System.out.println("Ticket booked successfully for " + customerName + " at seat " + seatNumber);
    }

    public void cancelTicket(int ticketNumber) {
        boolean found = false;
        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].getTicketNumber() == ticketNumber) {
                for (int j = i; j < ticketCount - 1; j++) {
                    tickets[j] = tickets[j + 1];
                }
                tickets[--ticketCount] = null;
                found = true;
                System.out.println("Ticket " + ticketNumber + " cancelled.");
                break;
            }
        }
        if (!found) {
            System.out.println("Ticket number " + ticketNumber + " not found.");
        }
    }

    public void displayAllTickets() {
        System.out.println("Current Bookings:");
        if (ticketCount == 0) {
            System.out.println("No bookings available.");
        } else {
            for (int i = 0; i < ticketCount; i++) {
                System.out.println(tickets[i]);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        BookingSystem bs = new BookingSystem();

        bs.bookTicket(1, "Alice", 1);
        bs.bookTicket(2, "Bob", 2);
        bs.bookTicket(3, "Carol", 3);

        bs.cancelTicket(2);
        bs.bookTicket(4, "David", 2);
        bs.displayAllTickets();
    }
}

