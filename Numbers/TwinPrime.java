import java.util.Scanner;

class TwinPrime{

    static boolean isPrime(int n){
        if(n < 2) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        for(int i = 3; i*i <= n; i += 2){
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a first number : ");
        if(!sc.hasNextInt()){
            System.out.print("Invalid Input!");
        }
        int num1 = sc.nextInt();

        System.out.print("Enter a second number : ");
        if(!sc.hasNextInt()){
            System.out.print("Invalid Input!");
        }
        int num2 = sc.nextInt();

        if(num1 <= 0 || num2 <= 0){
            System.out.print("Invalid input! Please enter positive integer");
            return;
        }

        if(Math.max(num1, num2) - Math.min(num1, num2) == 2){                 // | boolean isTwinPrime = Math.abs(num1 - num2) == 2
            if(isPrime(num1) && isPrime(num2)){                               // |                       && isPrime(num1)
                System.out.print(num1+" & "+num2+" is a Twin Prime Number");  // |                       && isPrime(num2);
            }else {                                                           // | if(isTwinPrime)
                System.out.print(num1+" & "+num2+" is Not Twin Prime Number");// |    System.out.print("Twin Prime Number");
            }                                                                 // | else
        }else {                                                               // |    System.out.print("Not Twin Prime Number");
            System.out.print(num1+" & "+num2+" is Not Twin Prime Number");    // |
        }                                                                     // |


    }
}