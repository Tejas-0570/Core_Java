/*
#4 Medium equals() and hashCode() contract
-----------------------------------------------------------------------------------------------------------------------------------
Duplicate employee detector

Create Employee class with empId and name. Add Employee objects to HashSet — WITHOUT overriding equals/hashCode. Show that two
employees with same empId are treated as different (stored as duplicates). Then override equals() and hashCode() correctly — now
HashSet correctly identifies them as same. This is the most critical HashSet concept.
-----------------------------------------------------------------------------------------------------------------------------------
🟡 Why this matters for every HashSet of objects: HashSet uses equals() and hashCode() to determine duplicates. For String and Integer
these are already overridden correctly by Java. For YOUR custom classes — Java uses default Object.equals() which compares memory
addresses, not field values. Two Employee objects with same empId are at different addresses — treated as different. You MUST
override both methods or HashSet breaks silently.
-----------------------------------------------------------------------------------------------------------------------------------
🔵 Modern approach — IDE generation or @Override: Modern IDEs (IntelliJ, Eclipse) auto-generate equals() and hashCode() from selected
fields. In Java 7+, use Objects.hash(empId, name) instead of manual hash calculation. In Java 16+, Records auto-generate both —
record Employee(int empId, String name){} and HashSet works correctly without any override.
-----------------------------------------------------------------------------------------------------------------------------------
🟣 Concept — The equals/hashCode contract (MUST know): Rule 1: If a.equals(b) is true → a.hashCode() MUST equal b.hashCode().
Rule 2: If a.hashCode() == b.hashCode() → a.equals(b) MAY be true (hash collision possible). Rule 3: If you override equals(),
you MUST override hashCode() — always both together, never one without the other. Breaking this contract causes HashSet to store
duplicates silently or lose objects during contains(). This contract applies to ALL hash-based collections — HashSet, HashMap,
LinkedHashMap, Hashtable.
-----------------------------------------------------------------------------------------------------------------------------------
WITHOUT override:
emp1(101,"Raj") + emp2(101,"Raj") → size=2 ❌ both stored
WITH override:
emp1(101,"Raj") + emp2(101,"Raj") → size=1 ✅ duplicate rejected
contains(emp2): true ✅ found correctly

Skills: equals() override, hashCode() override, Objects.hash(), instanceof check, equals/hashCode contract, silent duplicate bug
Hint at bottom ----->
 */

package Set.Hashset;

import java.util.HashSet;
import java.util.Objects;

public class DuplicateEmployeeDetector {
    public static void main(String[] args) {

        System.out.println("=========== WITHOUT equals()/hashCode() override ===========");
        HashSet<EmployeeNoOverride> rawEmployees = new HashSet<>();
        EmployeeNoOverride raw1 = new EmployeeNoOverride(101, "Tejas");
        EmployeeNoOverride raw2 = new EmployeeNoOverride(101, "Tejas");

        rawEmployees.add(raw1);
        rawEmployees.add(raw2);

        System.out.println(rawEmployees);
        System.out.println("Size: " + rawEmployees.size() + "  (expected 2 - treated as different objects)");
        System.out.println("raw1.equals(raw2): " + raw1.equals(raw2) + "  (expected false - default Object.equals compares memory address)");

        System.out.println("\n=========== WITH equals()/hashCode() override ===========");
        HashSet<Employee> employees = new HashSet<>();
        Employee e1 = new Employee(101, "Tejas");
        Employee e2 = new Employee(101, "Tejas");

        employees.add(e1);
        employees.add(e2);

        System.out.println(employees);
        System.out.println("Size: " + employees.size() + "  (expected 1 - duplicate correctly rejected)");
        System.out.println("e1.equals(e2): " + e1.equals(e2) + "  (expected true - same empId)");
        System.out.println("Contains e2: " + employees.contains(e2) + "  (expected true - found via equals/hashCode)");

        System.out.println("\n=========== Broken contract demo: equals() overridden, hashCode() NOT ===========");
        HashSet<BrokenEmployee> brokenSet = new HashSet<>();
        BrokenEmployee b1 = new BrokenEmployee(101, "Tejas");
        BrokenEmployee b2 = new BrokenEmployee(101, "Tejas");

        brokenSet.add(b1);
        brokenSet.add(b2);

        System.out.println("b1.equals(b2): " + b1.equals(b2) + "  (true - equals() says they match)");
        System.out.println("Size: " + brokenSet.size() + "  (still 2! - different hash codes send them to different buckets, equals() never even gets called)");
    }
}

// ---------------------------------------------------------------
// Step 1 — no overrides at all. HashSet falls back to Object's
// default equals()/hashCode(), which compare memory addresses.
// ---------------------------------------------------------------
class EmployeeNoOverride {
    private int empId;
    private String name;

    public EmployeeNoOverride(int empId, String name){
        this.empId = empId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{empId=" + empId + ", name='" + name + "'}";
    }
}

// ---------------------------------------------------------------
// Step 2 — properly overridden equals() and hashCode(), both based
// on the SAME field (empId), satisfying the equals/hashCode contract.
// ---------------------------------------------------------------
class Employee {
    private int empId;
    private String name;

    public Employee(int empId, String name){
        this.empId = empId;
        this.name = name;
    }

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;                 // same object reference — trivially equal
        }
        if (!(o instanceof Employee)) {
            return false;                // not an Employee (or null) — can't be equal
        }
        Employee e = (Employee) o;
        return this.empId == e.empId;    // business rule: same empId = same employee
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId);      // MUST use the same field(s) as equals()
    }

    @Override
    public String toString() {
        return "Employee{empId=" + empId + ", name='" + name + "'}";
    }
}

// ---------------------------------------------------------------
// Step 3 — the broken-contract trap: equals() overridden correctly,
// but hashCode() left as default. Shows the SILENT bug the contract
// warns about — equal-by-equals() objects still stored as duplicates,
// because they land in different hash buckets and equals() is never
// even called to compare them.
// ---------------------------------------------------------------
class BrokenEmployee {
    private int empId;
    private String name;

    public BrokenEmployee(int empId, String name){
        this.empId = empId;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrokenEmployee)) return false;
        BrokenEmployee e = (BrokenEmployee) o;
        return this.empId == e.empId;
    }

    // hashCode() deliberately NOT overridden — still uses Object's default
    // (memory-address-based) hash code, breaking the contract on purpose.
}

/*
Step 1 — Employee WITHOUT overrides:
class Employee { int empId; String name; Employee(int id, String n){...} }
Add two employees with same empId — print size() — shows 2. Wrong.
This is because Object.equals() does return this == other — memory address comparison.

Step 2 — Override equals():
@Override public boolean equals(Object o) {
if(this == o) return true;
if(!(o instanceof Employee)) return false;
Employee e = (Employee) o;
return this.empId == e.empId;
}

Step 3 — Override hashCode():
@Override public int hashCode() {
return Objects.hash(empId); // import java.util.Objects
}
Now add same two employees — size() = 1. Correct.

Why Objects.hash(): Manual hash like return empId * 31 works but Objects.hash() handles null safety and combines multiple fields
cleanly — Objects.hash(empId, name) uses both fields.

What happens if you override equals() but NOT hashCode():
Two equal employees get different hash codes → land in different buckets → HashSet never even compares them with equals() → both
stored as duplicates. Silent bug. This is why the contract says ALWAYS both.
 */