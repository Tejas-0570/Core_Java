/*
#9 Hard Real system — HashSet solving a real problem
-----------------------------------------------------------------------------------------------------------------------------------
Social media friend suggestion system

Each User has a userId and a HashSet of friends. Implement: addFriend(), removeFriend(), isFriend(), mutualFriends(User other) —
returns HashSet of common friends, suggestFriends(User other) — friends of friends who are not already friends. This combines HashSet
set operations with object design.
-----------------------------------------------------------------------------------------------------------------------------------
🟡 Why HashSet for friend lists: isFriend() check must be O(1) — social apps check friendship status millions of times per second
(feed generation, notification filtering, privacy checks). HashSet friends list makes this O(1) per check. mutualFriends() uses
retainAll() which is O(n) — unavoidable since you must compare all friends — but at least membership check inside is O(1).
Real social networks (Facebook, LinkedIn) use similar hash-based adjacency sets internally.
-----------------------------------------------------------------------------------------------------------------------------------
🔵 Real world scale — graph databases: At Facebook scale (1 billion users, average 200 friends), in-memory HashSets per user are
impossible — 200 billion entries. Real systems use graph databases (Neo4j) or distributed hash tables where friendship data is
partitioned across thousands of servers. But the algorithmic concept — hash-based adjacency lists — is identical to what you are
building here, just distributed.
-----------------------------------------------------------------------------------------------------------------------------------
🟣 Concept — HashSet as adjacency set in graphs: Friend relationships form a graph — users are nodes, friendships are edges.
Storing each user's friends in a HashSet creates a hash-based adjacency list representation. This is one of the most efficient
graph representations for social networks where the primary query is "are A and B connected?" — O(1) with HashSet. Matrix
representation would need O(1) but requires O(n²) memory — impossible at scale.
-----------------------------------------------------------------------------------------------------------------------------------
Raj's friends: [Sara, Ali, John]
Sara's friends: [Raj, Ali, Priya, Mike]
mutualFriends(Raj, Sara): [Ali] — in both
suggestFriends for Raj: [Priya, Mike] — Sara's friends, not Raj's friends yet

Skills: HashSet as graph adjacency list, bidirectional friendship, retainAll for mutual, addAll+removeAll for suggestions, userId as final key
Hint at bottom -->
 */

package Set.Hashset;

import java.util.HashSet;
import java.util.Objects;

public class SocialMediaFriendSuggestionSystem {
    public static void main(String[] args) {
        User raj  = new User("U1", "Raj");
        User sara = new User("U2", "Sara");
        User ali  = new User("U3", "Ali");
        User john = new User("U4", "John");
        User priya = new User("U5", "Priya");
        User mike = new User("U6", "Mike");

        raj.addFriend(sara);
        raj.addFriend(ali);
        raj.addFriend(john);
        sara.addFriend(ali);
        sara.addFriend(priya);
        sara.addFriend(mike);

        System.out.println("Raj's friends : " + raj.getFriends());
        System.out.println("Sara's friends: " + sara.getFriends());

        System.out.println("isFriend(Raj, Sara)  : " + raj.isFriend(sara));    // true
        System.out.println("isFriend(Raj, Priya) : " + raj.isFriend(priya));   // false

        System.out.println("Mutual(Raj, Sara)    : " + raj.mutualFriends(sara));  // [Ali]
        System.out.println("Suggestions for Raj  : " + raj.suggestFriends());     // [Priya, Mike]

        raj.addFriend(raj);   // rejected: cannot friend yourself

        raj.removeFriend(sara);
        System.out.println("After unfriending, Raj's friends : " + raj.getFriends());
        System.out.println("After unfriending, Sara's friends: " + sara.getFriends());
    }
}

class User {
    private final String userId;
    private final String name;
    private final HashSet<User> friends = new HashSet<>();

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getName() { return name; }

    // return a copy so outsiders cannot modify the friend list directly
    public HashSet<User> getFriends() { return new HashSet<>(friends); }

    public void addFriend(User u) {
        if (u == null || this.equals(u)) {
            System.out.println("Invalid friend request");
            return;
        }
        friends.add(u);        // bidirectional: friendship is mutual
        u.friends.add(this);
    }

    public void removeFriend(User u) {
        friends.remove(u);
        u.friends.remove(this);
    }

    public boolean isFriend(User u) {
        return friends.contains(u);   // O(1)
    }

    public HashSet<User> mutualFriends(User other) {
        HashSet<User> mutual = new HashSet<>(this.friends);   // copy first
        mutual.retainAll(other.friends);                       // keep only common
        return mutual;
    }

    public HashSet<User> suggestFriends() {
        HashSet<User> suggestions = new HashSet<>();
        for (User f : this.friends) {
            suggestions.addAll(f.friends);     // friends of friends
        }
        suggestions.removeAll(this.friends);   // drop people already friends
        suggestions.remove(this);              // drop self
        return suggestions;
    }

    // equals/hashCode on userId ONLY
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        return this.userId.equals(((User) o).userId);
    }

    @Override
    public int hashCode() { return Objects.hash(userId); }

    // name only: printing friends here would recurse forever (Raj -> Sara -> Raj ...)
    @Override
    public String toString() { return name; }
}

/*
User class:
class User {
private final String userId;
private String name;
private HashSet<User> friends = new HashSet<>();
// equals and hashCode based on userId only
@Override public int hashCode() { return Objects.hash(userId); }
@Override public boolean equals(Object o) { return ((User)o).userId.equals(this.userId); }
}

addFriend() — bidirectional:
void addFriend(User u) { friends.add(u); u.friends.add(this); } — friendship is mutual.

mutualFriends():
HashSet<User> mutual = new HashSet<>(this.friends) — copy
mutual.retainAll(other.friends) — keep only common friends
return mutual

suggestFriends():
HashSet<User> suggestions = new HashSet<>()
Loop through each friend: for(User f : this.friends)
Add their friends: suggestions.addAll(f.friends)
Remove already friends: suggestions.removeAll(this.friends)
Remove self: suggestions.remove(this)
return suggestions — friends of friends not yet your friends.
 */