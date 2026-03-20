import java.util.Scanner;
public class EvenOrOdd {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        if(!sc.hasNextInt()){
            System.out.print("Invalid input! Please enter a valid input");
            return;
        }
        int num = sc.nextInt();

        if(num == 0){
            System.out.println(num+" cannot be even or odd");
            return;
        }
        if(num < 0){
            System.out.print("Invalid Input! Please enter positive numbers");
            return;
        }

        if(num % 2 == 0){
            System.out.println(num+" is a Even Number");
        } else {
            System.out.println(num+" is a Odd Number");
        }
    }
}
