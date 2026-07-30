/*
Vehicle abstract class

Create an abstract class Vehicle with abstract methods start() and stop(), and a concrete method fuelType().
Create Car and Bike that implement start() and stop() differently. fuelType() is shared by all.

Car.start() → "Car engine starts with key"
Bike.start() → "Bike starts with kick"
fuelType() → "Runs on petrol" (same for all)
 */



package Abstraction;
public class VehicleAbstractClass {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.start();
        v.stop();
        v.fuelType();
        Vehicle v1 = new Bike();
        v1.start();
        v1.stop();
        v1.fuelType();

    }
}


abstract class Vehicle{

    abstract void start();
    abstract void stop();

    void fuelType(){
        System.out.println("Runs on petrol");
    }
}

class Car extends Vehicle {
    @Override
    void start(){
        System.out.println("Car engine starts with key");
    }

    @Override
    void stop(){
        System.out.println("Car stops when break is applied");
    }
}

class Bike extends Vehicle{
    @Override
    void start(){
        System.out.println("Bike starts with kick");
    }

    @Override
    void stop(){
        System.out.println("Bike stops when break applied");
    }
}