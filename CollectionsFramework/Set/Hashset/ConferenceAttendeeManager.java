/*
#6 Medium HashSet of objects — real system
-----------------------------------------------------------------------------------------------------------------------------------
Conference attendee manager

Create Attendee class (ticketId, name, session). Override equals/hashCode on ticketId only. Build conference system — register
attendee, check if registered, cancel registration, show all attendees, find attendees by session name (filter during iteration).
Handle duplicate ticket registration attempt.
-----------------------------------------------------------------------------------------------------------------------------------
🟡 Why HashSet for attendee management: Ticket IDs must be unique — HashSet enforces this automatically. contains() check before
entry is O(1) — at a real conference with 50000 attendees, the gate scanner cannot afford O(n) ArrayList search per scan. Every
ticket scan must be instant — HashSet makes it instant regardless of crowd size.
-----------------------------------------------------------------------------------------------------------------------------------
🔵 Real world — use HashMap for this: HashSet tells you IF an attendee exists. But to find attendee details BY ticketId, you need
HashMap<String, Attendee> — key is ticketId, value is Attendee object. Direct lookup by key in O(1). HashSet + linear search to find
details is two steps. You will implement this in HashMap problems — this problem builds the foundation.
-----------------------------------------------------------------------------------------------------------------------------------
🟣 Concept — Filtering during HashSet iteration: HashSet has no get(index) and no built-in filter. To filter by session — iterate
all attendees with for-each and check condition manually. This is O(n) — every filter on HashSet is always O(n) because there is
no index structure. HashSet optimises for membership testing (contains), not for searching by arbitrary fields. This limitation
naturally leads to HashMap.
-----------------------------------------------------------------------------------------------------------------------------------
register(T001, Raj, Java) → registered ✅
register(T001, Sara, Python) → duplicate ticket ❌ rejected
isRegistered(T001): true — O(1)
session filter "Java": [Raj, ...] — O(n) iteration
cancel(T002): removed ✅

Skills: equals/hashCode on ticketId only, dummy object for remove, session filtering, O(1) contains vs O(n) filter
Hint at bottom --->
 */

package Set.Hashset;

import java.util.HashSet;
import java.util.Objects;

public class ConferenceAttendeeManager {
    public static void main(String[] args) {
        ConferenceManager cm = new ConferenceManager();

        cm.register(new Attendee("T001", "Raj", "Java"));
        cm.register(new Attendee("T001", "Sara", "Python"));   // duplicate ticket -> rejected
        cm.register(new Attendee("T002", "Ali", "Python"));
        cm.register(new Attendee("T003", "John", "Java"));

        System.out.println("isRegistered(T001): " + cm.isRegistered("T001"));
        System.out.println("isRegistered(T999): " + cm.isRegistered("T999"));

        cm.showAll();
        cm.findBySession("Java");

        cm.cancel("T002");
        cm.cancel("T002");   // already cancelled -> not found
        cm.showAll();
    }
}

class Attendee {
    private final String ticketId;
    private final String name;
    private final String session;

    public Attendee(String ticketId, String name, String session) {
        this.ticketId = ticketId;
        this.name = name;
        this.session = session;
    }

    public String getTicketId() { return ticketId; }
    public String getName() { return name; }
    public String getSession() { return session; }

    // equals/hashCode on ticketId ONLY: name and session are deliberately ignored
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attendee)) return false;
        return this.ticketId.equals(((Attendee) o).ticketId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId);
    }

    @Override
    public String toString() {
        return ticketId + " | " + name + " | " + session;
    }
}

class ConferenceManager {
    private final HashSet<Attendee> attendees = new HashSet<>();

    public void register(Attendee a) {
        if (attendees.add(a)) {
            System.out.println("Registered: " + a.getName() + " (" + a.getTicketId() + ")");
        } else {
            System.out.println("Ticket already registered: " + a.getTicketId() + " (rejected)");
        }
    }

    public boolean isRegistered(String ticketId) {
        // dummy object: only ticketId matters for equals/hashCode
        return attendees.contains(new Attendee(ticketId, "", ""));
    }

    public void cancel(String ticketId) {
        if (attendees.remove(new Attendee(ticketId, "", ""))) {
            System.out.println("Cancelled: " + ticketId);
        } else {
            System.out.println("Ticket not found: " + ticketId);
        }
    }

    public void showAll() {
        if (attendees.isEmpty()) {
            System.out.println("No attendees registered");
            return;
        }
        System.out.println("---- All attendees ----");
        for (Attendee a : attendees) {
            System.out.println(a);
        }
    }

    public void findBySession(String session) {
        System.out.println("---- Session: " + session + " ----");
        boolean found = false;
        for (Attendee a : attendees) {          // O(n): HashSet has no index/filter
            if (a.getSession().equalsIgnoreCase(session)) {
                System.out.println(a.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No attendees in this session");
        }
    }
}

/*
Attendee class:
class Attendee {
private String ticketId, name, session;
// constructor, getters
@Override public boolean equals(Object o) {
if(!(o instanceof Attendee)) return false;
return this.ticketId.equals(((Attendee)o).ticketId);
}
@Override public int hashCode() { return Objects.hash(ticketId); }
}

Register — handle duplicate:
boolean added = attendees.add(newAttendee)
if(!added) System.out.println("Ticket already registered: "+ticketId)

Cancel by ticketId:
Cannot do attendees.remove(ticketId) — that looks for a String, not Attendee.
Create a dummy: attendees.remove(new Attendee(ticketId, "", ""))
Because equals/hashCode uses only ticketId — dummy with same ticketId matches the real one. This is a key HashSet of objects pattern.

Filter by session:
for(Attendee a : attendees) { if(a.getSession().equals("Java")) print(a); }
 */