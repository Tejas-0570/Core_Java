/*
#3 Easy LinkedList as Queue
-----------------------------------------------------------------------------------------------------------------------------------
Customer service queue

Simulate a customer service counter. Customers join the queue at the back, get served from the front — FIFO.
Operations: joinQueue (add to back), serve (remove from front), viewQueue (show all), position of a customer, how many waiting.
-----------------------------------------------------------------------------------------------------------------------------------
Why LinkedList not ArrayList: Queue means add at back, remove from front — constantly. ArrayList remove(0) is O(n) every single
serve operation because it shifts all remaining customers forward. LinkedList removeFirst() is O(1) always — just moves the
head pointer. For queues LinkedList is purpose-built.
-----------------------------------------------------------------------------------------------------------------------------------
join("Raj") → queue: [Raj]
join("Sara") → queue: [Raj, Sara]
join("Ali") → queue: [Raj, Sara, Ali]
serve() → "Serving Raj" → queue: [Sara, Ali]
position("Ali")→ position 2 in queue

Skills: offer(), poll(), peek(), FIFO concept, queue behavior, position search
Hint at bottom -->
 */

package LinkedList;

import java.util.LinkedList;

public class CustomerServiceQueue {
    public static void main(String[] args) {
        CustomerQueue cq = new CustomerQueue();

        cq.joinQueue("Raj");
        cq.joinQueue("Sara");
        cq.joinQueue("Ali");

        cq.serve();

        cq.position("Ali");
        cq.nextCustomer();

        cq.viewQueue();
    }
}

class CustomerQueue{
    LinkedList<String> customerList = new LinkedList<>();

    public void joinQueue(String name){
        customerList.offer(name);
        System.out.println("Queue: "+customerList);
    }

    public void serve(){
        String served = customerList.poll();
        if(served == null){
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.println("Serving "+served+" | Queue: "+customerList );
    }

    public void nextCustomer(){
        if(customerList.isEmpty()){
            System.out.println("Queue is Empty! No customer in queue");
            return;
        }
        System.out.println("Next Customer: "+customerList.peek());
    }


    public void position(String name){
        int pos = 1;
        for (String c : customerList){
            if(c.equals(name)){
                System.out.println("Position of "+name+" in queue: "+pos);
                return;
            }
            pos++;
        }
        System.out.println("No such customer");
    }

    public void viewQueue(){
        if(customerList.isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("---------------------- Waiting Customer List --------------------------");
        System.out.println("Queue: "+customerList);
    }
}


/*
Queue with LinkedList: LinkedList<String> queue = new LinkedList<>().

Join queue (add to back): queue.offer("Raj") or queue.addLast("Raj"). offer() is preferred for queues — returns false if
it fails instead of throwing exception.

Serve (remove from front): queue.poll() — removes and returns front. Returns null if empty — safer than remove() which
throws exception. Always check null before using result.

View front without removing: queue.peek() — who is next to be served.

Position of customer: Loop with index counter — int pos = 1; for(String c : queue) { if(c.equals(name)) print pos; pos++; }

FIFO — First In First Out: First customer to join is first to be served. Opposite of Stack.
 */