import java.util.Scanner;
public class HarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        if(num < 0){
            System.out.println("Please enter positive number");
            return;
        }
        if(num == 0){
            System.out.println(num+" is NOT a HARSHAD NUMBER");
            return;
        }
        int sum = 0;
        for(int i = num; i > 0; i /= 10){
            sum += i % 10;
        }
        if(num % sum == 0){
            System.out.println(num+" is a HARSHAD NUMBER");
        } else {
            System.out.println(num+" is NOT a HARSHAD NUMBER");
        }

    }
}
