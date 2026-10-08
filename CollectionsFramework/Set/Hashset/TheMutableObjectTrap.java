/*
#8 Medium Mutable objects in HashSet — danger
-----------------------------------------------------------------------------------------------------------------------------------
The mutable object trap

Add a Student object to HashSet. Then MODIFY the student's id field (the field used in hashCode) after adding. Try to find the
student with contains() — it returns false even though the object IS in the set. Try to remove it — fails too. The object is lost
inside its own HashSet. Demonstrate this trap and show the fix.

-----------------------------------------------------------------------------------------------------------------------------------
🟡 This is one of the most dangerous HashSet bugs in production: HashSet stores the object in a bucket based on its hashCode AT THE
TIME OF INSERTION. If you change the field used in hashCode after insertion, the object's new hashCode points to a different bucket
— but it is still sitting in the old bucket. contains() checks the new bucket — finds nothing. The object becomes unreachable — a
memory leak with a reference you cannot use.
-----------------------------------------------------------------------------------------------------------------------------------
🔵 The fix — immutable key fields: Fields used in hashCode and equals should ALWAYS be final — private final int empId. Immutable
objects (like String, Integer) are safe in HashSets because they cannot be changed after creation. This is one reason Java's String
is immutable — it is safe to use as HashMap key or HashSet element. For your custom classes — make identity fields final.
-----------------------------------------------------------------------------------------------------------------------------------
🟣 Concept — HashSet stores by bucket, not by reference: When you add object X, Java calls X.hashCode() → gets bucket number → stores
X there. Later when you call contains(X), Java calls X.hashCode() again → gets NEW bucket number (because you changed the field) →
checks that bucket → finds nothing → returns false. X is still in the OLD bucket — alive but unreachable. This is why mutable keys
in hash-based collections are a well-known anti-pattern in Java.
-----------------------------------------------------------------------------------------------------------------------------------
Student s = new Student(101, "Raj")
set.add(s) → added to bucket for hashCode(101)
s.setId(999) → id changed — hashCode now different
set.contains(s) → false ❌ — checks bucket for hashCode(999) — empty
set.remove(s) → false ❌ — cannot find to remove
set.size() → 1 — still there, but lost forever

Skills: mutable object danger, hashCode bucket mismatch, final fields, immutability importance, memory leak pattern
Hint at bottom --->
 */

package Set.Hashset;

public class TheMutableObjectTrap {
}


/*
Mutable Student — demonstrate the bug:
class Student {
private int id; // NOT final — dangerous
private String name;
public void setId(int id) { this.id = id; } // setter for id — dangerous
@Override public int hashCode() { return Objects.hash(id); }
@Override public boolean equals(Object o) { return ((Student)o).id == this.id; }
}

Trigger the bug:
HashSet<Student> set = new HashSet<>()
Student s = new Student(101, "Raj")
set.add(s)
System.out.println(set.contains(s)) // true
s.setId(999) // MUTATE after add
System.out.println(set.contains(s)) // false — BUG!
System.out.println(set.size()) // 1 — still there but lost

The fix — make id final:
private final int id; // no setter for id
Now setId() cannot exist — id cannot change after construction. Object stays in correct bucket forever.

Iterate to prove object is still inside:
for(Student st : set) System.out.println(st.getId()) — prints 999. Object IS there, just unreachable by contains().
 */