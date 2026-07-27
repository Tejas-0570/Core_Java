/*
Employee hierarchy

Create Employee base class with name and baseSalary.
Create Manager (adds teamSize, bonus per member = 500) and Developer (adds techStack, extra = 2000) that extend Employee.
Each should have a calcSalary() method returning total pay.

Manager name="Amit", base=50000, team=5 → salary = 52500
Developer name="Sara", base=45000 → salary = 47000
 */


package Inheritance;
public class EmployeeHierarchy {
    public static void main(String[] args) {
        Manager m = new Manager("Amit", 50000, 5);
        m.displayInfo();

        Developer d = new Developer("Sara", 45000, "MERN");
        d.displayInfo();
    }
}


class Employee{
    private String name;
    private int baseSalary;

    Employee(String name, int baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName(){
        return name;
    }

    public int getBaseSalary() {
        return baseSalary;
    }
    public int calcSalary(){
        return baseSalary;
    }
    public void displayInfo(){
        System.out.println("Name: " + name + " | Total Salary: " + calcSalary());
    }

}


class Manager extends Employee{
    private int teamSize;
    private int bonusPerMember = 500;

    Manager(String name, int baseSalary, int teamSize){
        super(name, baseSalary);
        this.teamSize = teamSize;
    }

    @Override
    public int calcSalary(){
        return super.calcSalary() + (teamSize * bonusPerMember);
    }

    @Override
    public void displayInfo(){
        System.out.println("Name: "+getName()+" | Base: "+getBaseSalary()+" | Team Size: "+teamSize+" | Bonus: "+(teamSize*bonusPerMember)+" | Total: "+calcSalary());
    }
}

class Developer extends Employee{
    private String techStack;
    private int extra = 2000;

    Developer(String name, int baseSalary, String techStack){
        super(name, baseSalary);
        this.techStack = techStack;
    }

    @Override
    public int calcSalary(){
        return super.calcSalary() + extra;
    }

    @Override
    public void displayInfo(){
        System.out.println("Name: "+getName()+" | Base: "+ getBaseSalary()+" | Tech Stack: "+techStack+" | Extra: "+extra+" | Total: "+calcSalary());
    }
}