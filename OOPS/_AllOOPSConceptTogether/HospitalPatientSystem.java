/*
Hospital patient system

Abstract class Person with private name, age, id. Class Patient extends Person — adds disease, admitDate, isAdmitted.
Class Doctor extends Person — adds specialization, and method treat(Patient p) which prints treatment info.
Simulate a doctor treating multiple patients.

Doctor: Dr. Sharma | Cardiology
Patient: Raj | fever | admitted: true
treat() → "Dr. Sharma treating Raj for fever"

Skills: abstract class, object as method parameter, Patient[] array, inter-object communication

 */

package _AllOOPSConceptTogether;
public class HospitalPatientSystem {
    public static void main(String[] args) {
        Patient p = new Patient("Raj", 25, 101, "Fever", "04-08-2026", true);
        Doctor d = new Doctor("Sharma", 35, 1, "Cardiology");

        d.displayInfo();
        p.displayInfo();

        d.treat(p);
    }
}

abstract class Person{
    private String name;
    private int age;
    private int id;

    Person(String name, int age, int id){
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public abstract void displayInfo();

//  ---------------- Getters --------------------
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getId(){
        return id;
    }
}

class Patient extends Person{
    String disease;
    String admitDate;
    boolean isAdmitted;
    Patient(String name, int age, int id, String disease, String admitDate, boolean isAdmitted){
        super(name, age, id);
        this.disease = disease;
        this.admitDate = admitDate;
        this.isAdmitted = isAdmitted;
    }

    @Override
    public void displayInfo(){
        System.out.println("Patient: "+getName()+" | Disease: "+disease+" | admitted: "+isAdmitted);
    }
}

class Doctor extends Person{
    String specialization;
    Doctor(String name, int age, int id, String specialization){
        super(name, age, id);
        this.specialization = specialization;
    }

    @Override
    public void displayInfo(){
        System.out.println("Doctor: Dr. "+getName()+" | Specialization: "+specialization);
    }

    void treat(Patient p){
        System.out.println("Dr."+getName()+" treating "+p.getName()+" for "+p.disease);
    }
}