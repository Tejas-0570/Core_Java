/*
Smart home devices

Interface Controllable with turnOn(), turnOff(), getStatus(). Implement SmartLight (brightness 0-100), SmartFan (speed 1-5),
SmartAC (temperature 16-30). Each device has extra controls — light has setBrightness(), fan has setSpeed(), AC has setTemp().

Light: turnOn() → "Light ON" | setBrightness(80) → "Brightness: 80%"
Fan: turnOn() → "Fan ON" | setSpeed(3) → "Speed: 3/5"
AC: turnOn() → "AC ON" | setTemp(24) → "Temperature: 24°C"

Skills: interface, extra class methods, validation in setters, interface vs specific reference

 */

package Abstraction;
public class SmartHomeDevices {
    public static void main(String[] args) {
        SmartLight sl = new SmartLight();
        SmartFan sf = new SmartFan();
        SmartAC sa = new SmartAC();

        System.out.println("----------------- Smart Light -----------------------");
        sl.turnOn();
        sl.setBrightness(80);
        sl.turnOff();
        sl.getStatus();

        System.out.println("----------------- Smart Fan -----------------------");
        sf.turnOn();
        sf.setSpeed(3);
        sf.turnOff();
        sf.getStatus();

        System.out.println("----------------- Smart AC -----------------------");
        sa.turnOn();
        sa.setTemp(20);
        sa.turnOff();
        sa.getStatus();

    }
}

interface Controllable{
    void turnOn();
    void turnOff();
    void getStatus();
}

class SmartLight implements Controllable{
    int brightness;
    boolean status;
    @Override
    public void turnOn(){
        status = true;
        System.out.println("Light ON");
    }
    @Override
    public void turnOff(){
        status = false;
        System.out.println("Light OFF");
    }
    @Override
    public void getStatus(){
        System.out.println("Light --> Status :"+((status)?"ON":"OFF")+" | Brightness: "+brightness);
    }

    public void setBrightness(int brightness){
        if(brightness < 0 || brightness > 100){
            System.out.println("Invalid brightness number! Brightness must within 0-100");
            return;
        }
        this.brightness = brightness;
    }
}

class SmartFan implements Controllable{
    int speed;
    boolean status;
    @Override
    public void turnOn(){
        status = true;
        System.out.println("Fan ON");
    }
    @Override
    public void turnOff(){
        status = false;
        System.out.println("Fan OFF");
    }
    @Override
    public void getStatus(){
        System.out.println("Fan --> Status :"+((status)?"ON":"OFF")+" | Speed: "+speed);
    }

    public void setSpeed(int speed){
        if(speed < 1 || speed > 5){
            System.out.println("Invalid speed number! Speed must be within 1-5");
            return;
        }
        this.speed = speed;
    }
}

class SmartAC implements Controllable{
    int temperature;
    boolean status;
    @Override
    public void turnOn(){
        status = true;
        System.out.println("AC ON");
    }
    @Override
    public void turnOff(){
        status = false;
        System.out.println("AC OFF");
    }
    @Override
    public void getStatus(){
        System.out.println("AC --> Status :"+((status)?"ON":"OFF")+" | Temperature: "+temperature);
    }

    public void setTemp(int temperature){
        if(temperature < 16 || temperature > 30){
            System.out.println("Invalid temperature number! Temperature must be within 16-30");
            return;
        }
        this.temperature = temperature;
    }
}
