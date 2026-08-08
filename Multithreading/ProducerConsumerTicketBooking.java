/*
Producer consumer — ticket booking

TicketPool has 5 tickets. Producer thread adds tickets one by one (max 10 total). Consumer thread books tickets.
Use synchronized with wait() and notify() — consumer waits when pool is empty, producer notifies when ticket added.
No ticket should be double-booked.

Producer: "Ticket added — pool: 3"
Consumer: "Ticket booked — pool: 2"
Consumer: pool empty → waiting...
Producer: adds ticket → notifies consumer

Skills: wait(), notify(), notifyAll(), producer-consumer pattern, synchronized block, monitor lock

 */

public class ProducerConsumerTicketBooking {
    public static void main(String[] args) {
        TicketPool pool = new TicketPool();

        Thread producer = new Thread(new Producer(pool));
        Thread consumer = new Thread(new Consumer(pool));

        producer.start();
        consumer.start();
    }
}

class TicketPool {
    private int tickets = 0;
    private int total = 0;
    private static final int CAPACITY = 5;
    private static final int MAX_TOTAL = 10;

    synchronized void addTicket() {
        while (tickets == CAPACITY) {
            try {
                System.out.println("Producer: pool full → waiting...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        tickets++;
        total++;
        System.out.println("Ticket added -- pool: " + tickets + " | total produced: " + total);
        notifyAll();   // wake up any consumer waiting for a ticket
    }

    synchronized void bookTicket() {
        while (tickets == 0) {
            try {
                System.out.println("Consumer: pool empty → waiting...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        tickets--;
        System.out.println("Ticket booked -- pool: " + tickets);
        notifyAll();   // wake up any producer waiting for space
    }

    synchronized int getTotal() {
        return total;
    }
}

class Producer implements Runnable {
    private TicketPool pool;

    Producer(TicketPool pool) {
        this.pool = pool;
    }

    public void run() {
        while (pool.getTotal() < 10) {
            pool.addTicket();
            try {
                Thread.sleep(100);   // simulate time taken to create a ticket
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Producer: reached max of 10 tickets, stopping.");
    }
}

class Consumer implements Runnable {
    private TicketPool pool;

    Consumer(TicketPool pool) {
        this.pool = pool;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {   // book exactly 10, matching total ever produced
            pool.bookTicket();
            try {
                Thread.sleep(150);   // simulate time taken to book a ticket
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consumer: booked all 10 tickets, stopping.");
    }
}