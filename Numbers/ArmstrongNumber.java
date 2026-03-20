/*
An Armstrong number is a number that is equal to the sum
of its digits each raised to the power of the number of digits.

Example:
153 is an Armstrong number because(number has 3 digit ==> power =3)
1³ + 5³ + 3³ = 1 + 125 + 27 = 153

1⁴ + 6⁴ + 3⁴ + 4⁴ = 1 + 1296 + 81 + 256 = 1634
 */

import java.util.Scanner;
class ArmstrongNumber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        int count = 0;

        for(int i = num; i != 0; i /= 10){
            count++;
        }
        int sum = 0;
        for(int i = num; i != 0; i /= 10){
            int lastDigit = i % 10;
            int pow = 1;
            for(int j=1; j <= count; j++){
                pow *= lastDigit;
            }
            sum += pow;
        }

        if(num == sum){
            System.out.print(num+" is a Armstrong Number");
        } else {
            System.out.print(num+" is Not a Armstron Number");
        }
    }
}

// ----------------------------- Clean Code ---------------------------------------------------

/*
import java.util.Scanner;
class ArmStrongNumber{

    static int DigitCount(int n){
        int count = 0;
        while(n > 0){
            count++;
            n /= 10;
        }
        return count;
    }

    static int power(int base, int raise){
        int result = 1;
        for(int i = 1; i <= raise; i++){
            result *= base;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        if(!sc.hasNextInt()){
            System.out.print("Invalid Input! Please enter valid input");
            return;
        }
        int num = sc.nextInt();
        if(num < 0){
            System.out.print("Invalid input! Please enter positive number");
            return;
        }
        int count = DigitCount(num);
        int temp = num, sum = 0;

        while(temp > 0){
            int lastDigi = temp % 10;
            sum += power(lastDigi, count);
            temp /= 10;
        }

        if(num == sum){
            System.out.print(num+" is an Armstrong Number");
        } else {
            System.out.print(num+" is Not an Armstrong Number");
        }
    }
}


 */