/*
Parking lot system

Interface Parkable with park() and leave(). Abstract class Vehicle with private regNo, ownerName, type.
Car, Bike, Truck extend Vehicle and implement Parkable. ParkingLot class holds Vehicle[] of size 5.
Methods: addVehicle(), removeVehicle(regNo), showSlots(), isFull().

addVehicle(car) → "Car parked at slot 1"
addVehicle(bike) → "Bike parked at slot 2"
removeVehicle(reg) → "MH12AB1234 has left slot 1"
showSlots() → prints all 5 slots — occupied or empty

Skills: interface + abstract class together, null slot management, search by field, ParkingLot as separate class

 */

package _AllOOPSConceptTogether;
public class ParkingLotSystem {
    public static void main(String[] args) {
        Car car = new Car("Tejas", "MH12AB1234", "Car");
        Bike bike = new Bike("Navin", "MH12CD5678", "Bike");
        Truck truck = new Truck("Manohar", "MH10AA1234", "Truck");
        ParkingLot lot = new ParkingLot();

        lot.addVehicle(car);
        lot.addVehicle(bike);
        lot.addVehicle(truck);
        System.out.println(lot.isFull() ? "Parking lot is Full":"Parking lot is not Full");

        lot.removeVehicle("MH12AB1234");
        lot.removeVehicle("MH12CD5678");
        lot.removeVehicle("MH10AA1234");
        lot.showSlots();




    }
}

interface Parkable{
    void park();
    void leave();
}

abstract class Vehicle{
    private String ownerName;
    private String regNo;
    private String type;

    Vehicle(String ownerName, String regNo, String type){
        this.ownerName = ownerName;
        this.regNo = regNo;
        this.type = type;
    }

//  ------------- Getters ---------------
    public String getOwnerName(){
        return ownerName;
    }
    public String getRegNo(){
        return regNo;
    }
    public String getType(){
        return type;
    }
}

class Car extends Vehicle implements Parkable{
    Car(String ownerName, String regNo, String type){
        super(ownerName, regNo, type);
    }

    @Override
    public void park(){
    }

    @Override
    public void leave(){
    }

}

class Bike extends Vehicle implements Parkable{
    Bike(String ownerName, String regNo, String type){
        super(ownerName, regNo, type);
    }

    @Override
    public void park(){

    }

    @Override
    public void leave(){

    }
}

class Truck extends Vehicle implements Parkable{
    Truck(String ownerName, String regNo, String type){
        super(ownerName, regNo, type);
    }
    @Override
    public void park(){

    }

    @Override
    public void leave(){

    }
}

class ParkingLot{
    Vehicle[] slots = new Vehicle[5];

    public void addVehicle(Vehicle vehicle){
        for(int i = 0; i < slots.length; i++){
            if(slots[i] == null){
                slots[i] = vehicle;
                System.out.println(vehicle.getType()+" is parked at slot "+(i+1));
                return;
            }
        }
        System.out.println("Parking lot is full");
    }

    public void removeVehicle(String regNo){
        for(int i = 0; i < slots.length; i++){
            if(slots[i] != null && slots[i].getRegNo().equals(regNo)){
                System.out.println(slots[i].getRegNo()+" has left slot "+(i+1));
                slots[i] = null;
                return;
            }
        }
        System.out.println("Vehicle with regNo "+regNo+" not found");
    }

    public void showSlots() {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null) {
                System.out.println("Slot " + (i + 1) + ": Empty");
            } else {
                System.out.println("Slot " + (i + 1) + ": " + slots[i].getType() +
                        " | " + slots[i].getRegNo() + " | Owner: " + slots[i].getOwnerName());
            }
        }
    }

    public boolean isFull() {
        for (Vehicle v : slots) {
            if (v == null) {
                return false;   // found an empty slot → not full
            }
        }
        return true;
    }

}