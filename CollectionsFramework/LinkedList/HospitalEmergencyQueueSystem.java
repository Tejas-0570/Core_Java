/*
#9 Hard Real system — all operations combined
-----------------------------------------------------------------------------------------------------------------------------------
Hospital emergency queue system

Build an emergency room queue. Patients have name, severity (1=critical, 2=serious, 3=normal). CRITICAL patients always go to front,
SERIOUS go to middle (after all critical), NORMAL go to back. Remove a specific patient by name if they leave. Show queue with positions.
-----------------------------------------------------------------------------------------------------------------------------------
Why LinkedList not ArrayList: Every patient admission is an insertion — at front, middle, or back depending on severity.
With 100 patients waiting, inserting a critical patient at front using ArrayList shifts all 100. LinkedList inserts at front
with zero shifting. This is real-world priority queue thinking.
-----------------------------------------------------------------------------------------------------------------------------------
admit(Raj, NORMAL) → [Raj-Normal]
admit(Sara, SERIOUS) → [Sara-Serious, Raj-Normal]
admit(Ali, CRITICAL) → [Ali-Critical, Sara-Serious, Raj-Normal]
admit(John, CRITICAL) → [Ali-Critical, John-Critical, Sara-Serious, Raj-Normal]
remove("Sara") → [Ali-Critical, John-Critical, Raj-Normal]

Skills: priority insertion, ListIterator add at position, Patient object, severity-based ordering, it.previous() + it.add()
Hint at bottom -->
 */

package LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class HospitalEmergencyQueueSystem {
    public static void main(String[] args) {
        Patient p1 = new Patient("Raj", 3);
        Patient p2 = new Patient("Sara", 2);
        Patient p3 = new Patient("Ali", 1);
        Patient p4 = new Patient("John", 1);

        EmergencyRoom er = new EmergencyRoom();
        er.admit(p1);
        er.admit(p2);
        er.admit(p3);
        er.admit(p4);

        er.remove("Sara");

        er.display();
    }
}

class Patient{
    private String name;
    private int severity;

    Patient(String name, int severity){
        this.name = name;
        this.severity = severity;
    }

    public String getName(){
        return name;
    }
    public int getSeverity(){
        return severity;
    }
}

class EmergencyRoom{
    LinkedList<Patient> patientList = new LinkedList<>();

    public void admit(Patient newPatient){
        ListIterator<Patient> it = patientList.listIterator();
        while(it.hasNext()){
            Patient p = it.next();
            if(p.getSeverity() > newPatient.getSeverity()){
                it.previous();
                it.add(newPatient);
                return;
            }
        }
        it.add(newPatient);
    }

    public void remove(String name){
        ListIterator<Patient> it = patientList.listIterator();
        while(it.hasNext()){
            Patient p = it.next();
            if(p.getName().equals(name)){
                it.remove();
                System.out.println("Removed");
                return;
            }
        }
        System.out.println("No such name found in List");
    }

    public void display(){
        for (Patient p : patientList) {
            System.out.println("Name :" + p.getName() + " | Severity: " + (p.getSeverity() == 1 ? "CRITICAL" : (p.getSeverity() == 2 ? "SERIOUS" : "NORMAL")));
        }
    }

}


/*
Patient class: private name, severity (int 1/2/3). Constructor + getters.

admit() logic — finding insertion position:
— severity 1 (CRITICAL): find last critical patient using ListIterator, insert after them. If no critical exists, addFirst.
— severity 2 (SERIOUS): find last serious patient, insert after. If no serious, insert after all critical (before first normal).
— severity 3 (NORMAL): addLast — always at back.

Finding insertion point with ListIterator: ListIterator<Patient> it = queue.listIterator();
        while(it.hasNext()){
            Patient p = it.next();
            if(p.getSeverity() > newPatient.getSeverity()){
                it.previous();
                it.add(newPatient);
                return;
            }
        }
        it.add(newPatient);
— traverse until you find someone less severe, go back one step, insert.

Remove by name: Iterator loop — find patient by name using equals(), call it.remove().
 */