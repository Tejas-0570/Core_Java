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

public class ConferenceAttendeeManager {
    public static void main(String[] args) {

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