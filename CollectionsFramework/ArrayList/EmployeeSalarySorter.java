/*
Employee salary sorter

Create Employee class (name, department, salary). Make it implement Comparable<Employee> to sort by salary ascending by default.
Use Collections.sort() to sort the list. Then sort by name alphabetically using a separate Comparator. Show the difference
between Comparable and Comparator clearly.

Employees: Raj-IT-55000, Sara-HR-72000, Ali-IT-48000, John-HR-61000
Sort by salary: Ali-48000, Raj-55000, John-61000, Sara-72000
Sort by name: Ali, John, Raj, Sara
Sort by dept then salary:HR:John,Sara | IT:Ali,Raj

Skills: Comparable, compareTo(), Comparator, compare(), Collections.sort() with comparator, natural vs custom ordering
Hint at bottom -->
 */

package ArrayList;

public class EmployeeSalarySorter {
    public static void main(String[] args) {

    }
}



/*
Comparable — natural ordering (1 way): In Employee class: implements Comparable<Employee>.
Add method: public int compareTo(Employee other) { return this.salary - other.salary; }.
Positive = this comes after, negative = this comes before, zero = equal. Now Collections.sort(employees) uses this automatically.

Comparator — custom ordering (multiple ways):
Collections.sort(employees, new Comparator<Employee>() {
 public int compare(Employee a, Employee b) {
 return a.getName().compareTo(b.getName());
 }
 }); — anonymous class. Each Comparator gives a different sort without changing Employee class.

Key difference: Comparable is baked into the class — one natural order. Comparator is external —
unlimited different orderings without touching the class. Real projects use Comparator far more.

Dept then salary: In comparator — first compare dept, if equal then compare salary.
 */