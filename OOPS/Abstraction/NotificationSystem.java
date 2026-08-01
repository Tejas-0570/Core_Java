/*
Notification system (interface)

Create an interface Notifiable with method sendNotification(String message).
Create EmailNotification, SmsNotification, and PushNotification that implement it.
Call all three through a Notifiable reference.

Email → "Sending email: Your OTP is 1234"
SMS → "Sending SMS: Your OTP is 1234"
Push → "Sending push: Your OTP is 1234"
 */


package Abstraction;
public class NotificationSystem {
    public static void main(String[] args) {
        Notifiable[] n = new Notifiable[3];
        n[0] = new EmailNotification();
        n[1] = new SmsNotification();
        n[2] = new PushNotification();

        String message = "Your OTP is 1234";

        for(Notifiable i : n){
            i.sendNotification(message);
        }

    }
}

interface Notifiable{
    void sendNotification(String message);
}

class EmailNotification implements Notifiable{
    @Override
    public void sendNotification(String message){
        System.out.println("Sending Email: "+message);
    }
}

class SmsNotification implements Notifiable{
    @Override
    public void sendNotification(String message){
        System.out.println("Sending SMS: "+message);
    }
}

class PushNotification implements Notifiable{
    @Override
    public void sendNotification(String message){
        System.out.println("Sending Push: "+message);
    }
}