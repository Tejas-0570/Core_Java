/*
Game character system

Abstract class GameCharacter with private name, health, attackPower. Concrete methods takeDamage(int dmg), isAlive(), displayStatus().
Abstract methods attack() and specialAbility(). Subclasses Warrior, Mage, Archer implement attack and specialAbility differently.

Skills: abstract class, shared concrete methods, abstract methods, health state, GameCharacter[] array, battle loop
*/

package Abstraction;

public class GameCharacterSystem {
    public static void main(String[] args) {
        Warrior w = new Warrior("Gojo", 300, 50);
        Mage m = new Mage("Luffy", 250, 40);
        Archer a = new Archer("Bahubali", 280, 45);

        GameCharacter[] fighters = { w, m, a };

        System.out.println("===================== BATTLE START =====================");

        // Round 1 — everyone attacks
        battleRound(fighters);

        System.out.println("---------------------------------------------------------");

        // Simulate some damage
        w.takeDamage(m.getAttackPower());
        m.takeDamage(a.getAttackPower());
        a.takeDamage(w.getAttackPower());

        // Knock out the mage to demonstrate isAlive() guard
        m.takeDamage(1000);

        System.out.println("After damage exchange:");
        for (GameCharacter fighter : fighters) {
            fighter.displayStatus();
        }

        System.out.println("---------------------------------------------------------");
        System.out.println("Round 2 (dead characters should not act):");
        battleRound(fighters);
    }

    // Battle loop — polymorphic call, guarded by isAlive()
    static void battleRound(GameCharacter[] fighters) {
        for (GameCharacter fighter : fighters) {
            if (fighter.isAlive().equals("Alive")) {
                fighter.attack();
                fighter.specialAbility();
            } else {
                System.out.println(fighter.getName() + " is dead and cannot act.");
            }
        }
    }
}

abstract class GameCharacter {
    private String name;
    private int health;
    private int attackPower;

    public GameCharacter(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    // ----------------- Getters -----------------
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    // ----------------- Concrete Methods -----------------
    public void takeDamage(int dmg) {
        health -= dmg;
        if (health < 0) {
            health = 0; // prevent negative health display
        }
    }

    public String isAlive() {
        return (health > 0) ? "Alive" : "Dead";
    }

    public void displayStatus() {
        System.out.println("Name: " + name + " | Health: " + health +
                " | Attack Power: " + attackPower + " | Status: " + isAlive());
    }

    // ----------------- Abstract Methods -----------------
    public abstract void attack();
    public abstract void specialAbility();
}

class Warrior extends GameCharacter {
    Warrior(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack() {
        System.out.println(getName() + ": Sword slash — " + getAttackPower() + " dmg");
    }

    @Override
    public void specialAbility() {
        System.out.println(getName() + ": Shield bash stuns!");
    }
}

class Mage extends GameCharacter {
    Mage(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack() {
        System.out.println(getName() + ": Magic bolt — " + getAttackPower() + " dmg");
    }

    @Override
    public void specialAbility() {
        System.out.println(getName() + ": Fireball — 120 dmg!");
    }
}

class Archer extends GameCharacter {
    Archer(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack() {
        System.out.println(getName() + ": Long-range shot — " + getAttackPower() + " dmg");
    }

    @Override
    public void specialAbility() {
        System.out.println(getName() + ": Piercing arrow!");
    }
}