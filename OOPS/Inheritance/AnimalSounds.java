/*
Animal sounds

Create a parent class Animal with fields name and age, and a method makeSound().
Create child classes Dog, Cat, and Cow that extend Animal and each override makeSound() with their own sound.

Animal → makeSound() prints "Animal Sound"
Dog → makeSound() prints "Woof!"
Cat → makeSound() prints "Meow!"
Cow → makeSound() prints "Moo!"
 */
package Inheritance;
public class AnimalSounds {
    public static void main(String[] args) {
        Animal d = new Dog("Bruno", 15);
        Animal c = new Cat("Tom", 10);
        Animal cw = new Cow("Gau", 30);

        d.displayInfo();
        c.displayInfo();
        cw.displayInfo();
    }
}

class Animal{
    String name;
    int age;

    Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    void makeSound(){
        System.out.println("Animal Sound");
    }

    void displayInfo(){
        System.out.print("Animal Name: "+this.name+" | Age: "+this.age+" | Sound: ");
        makeSound();
    }

}

class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound(){
        System.out.println("Woof!");
    }

}

class Cat extends Animal {
    Cat(String name, int age){
        super(name, age);
    }

    @Override
    void makeSound(){
        System.out.println("Meow!");
    }

}

class Cow extends Animal {
    Cow(String name, int age){
        super(name, age);
    }

    @Override
    void makeSound(){
        System.out.println("Moo!");
    }
}



/*
Why we not create Object like this "Dog d = new Dog()"?

Both are valid — but different
Dog d = new Dog("Bruno", 5);      // Dog reference → Dog object
Animal d = new Dog("Bruno", 5);   // Animal reference → Dog object

Dog d = new Dog() — specific reference
Dog d = new Dog("Bruno", 5);
Here the reference type is Dog. You can access everything — Animal fields, Animal methods, AND anything Dog-specific.
d.name = "Bruno";     // ✅ from Animal
d.makeSound();        // ✅ from Animal, overridden in Dog
d.fetch();            // ✅ Dog specific method — accessible


Animal d = new Dog() — parent reference
Animal d = new Dog("Bruno", 5);
Here the reference type is Animal. You can only see what Animal knows about — even though the actual object is a Dog.
d.name = "Bruno";     // ✅ from Animal
d.makeSound();        // ✅ calls Dog's version at runtime — polymorphism!
d.fetch();            // ❌ Animal doesn't know about fetch() — compile error

So why use Animal d = new Dog()?
The real power shows when you have an array or method that handles multiple animal types together.
-------------------------------------------------------------------------------
// with specific references — you need separate variables for each type
Dog d = new Dog("Bruno", 5);
Cat c = new Cat("Whiskers", 3);
Cow cow = new Cow("Gau", 7);

// call displayInfo one by one — no way to loop
d.displayInfo();
c.displayInfo();
cow.displayInfo();

-------------------------------------------------------------------------------

// with parent reference — one array holds all of them
Animal[] animals = new Animal[3];
animals[0] = new Dog("Bruno", 5);
animals[1] = new Cat("Whiskers", 3);
animals[2] = new Cow("Gau", 7);

// one loop handles all — this is the real power
for (int i = 0; i < animals.length; i++) {
    animals[i].displayInfo();   // each calls its own version automatically
}

-------------------------------------------------------------------------------

Same loop, same method call — but Dog prints Woof, Cat prints Meow, Cow prints Moo.
Java decides at runtime which version to call based on the actual object, not the reference type.


 */