import java.util.Scanner;
public class FactorialOfNumber {

    static int Factorial(int n){
        if(n == 0 || n == 1) return 1;
        int fact = 1;
        while(n > 1){
            fact *= n;
            n--;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        if(!sc.hasNextInt()){
            System.out.print("Invalid input! Please enter a valid input");
            return;
        }
        int num = sc.nextInt();

        if(num < 0){
            System.out.print("Invalid input! Please enter positive number");
            return;
        }
        int result = Factorial(num);
        System.out.print("Factorial of "+num+" = "+result);

    }
}
