class TicketBookingSystem {
    private int availableSeats = 5;

    // Synchronized method to book seats
    public synchronized void bookSeat(String name, int seats) {
        if (seats <= availableSeats) {
            System.out.println(name + " successfully booked " + seats + " seat(s).");
            availableSeats -= seats;
        } else {
            System.out.println("Sorry, " + name + ". Not enough seats available.");
        }
    }
}

class Customer extends Thread {
    private TicketBookingSystem bookingSystem;
    private String name;
    private int seats;

    public Customer(TicketBookingSystem bookingSystem, String name, int seats, int priority) {
        this.bookingSystem = bookingSystem;
        this.name = name;
        this.seats = seats;
        this.setPriority(priority);
    }

    @Override
    public void run() {
        bookingSystem.bookSeat(name, seats);
    }
}

public class Main {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem();

        // Creating threads for customers
        Customer vip1 = new Customer(bookingSystem, "VIP Customer 1", 2, Thread.MAX_PRIORITY);
        Customer vip2 = new Customer(bookingSystem, "VIP Customer 2", 2, Thread.MAX_PRIORITY);
        Customer regular1 = new Customer(bookingSystem, "Regular Customer 1", 1, Thread.NORM_PRIORITY);
        Customer regular2 = new Customer(bookingSystem, "Regular Customer 2", 2, Thread.NORM_PRIORITY);

        // Starting threads
        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();
    }
}
