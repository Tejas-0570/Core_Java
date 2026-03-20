/*
A Strong number is a number where the sum of the factorials of its digits is equal to the number itself.

Example:
145

Check:
1! + 4! + 5!
= 1 + 24 + 120
= 145

✔️ So, 145 is a Strong number
 */

import java.util.Scanner;
class StrongNumber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        int num = sc.nextInt();

        int factSum = 0;
        for(int i = num; i > 0; i /= 10){
            int lastDigit = i % 10;
            int fact = 1;
            for(int j = lastDigit ; j > 1; j--){
                fact *= j;
            }
            factSum += fact;
        }

        if(num == factSum){
            System.out.print(num+" is a Strong Number");
        }
        else{
            System.out.print(num+" is Not a Strong Number");
        }
    }
}


//------------------------------------------------------------------------------------------
/* Above code not satisfies all possible scenarios

e.g. if user enter negative number or if enter 0. And if digit repeated in number then loop runs again
so why we want to run loop again, first we calculate the factorial or each number from 0-9 and store it in array.

*/
/*
import java.util.Scanner;
class StrongNumber{

    static int[] PreComputedFactorial(){
        int[] fact = new int[10];
        fact[0] = 1;
        for(int i = 1; i <= 9; i++){
            fact[i] = fact[i - 1] * i;
        }
        return fact;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        if(!sc.hasNextInt()){
            System.out.print("Invalid input! Please enter a valid input");
            return;
        }
        int num = sc.nextInt();

        if (num < 0){
            System.out.print("Invalid input! Please enter positive number");
            return;
        }
        int[] fact = PreComputedFactorial();
        int factSum = 0;
        int temp = num;
        while(temp > 0){
            int lastDigit = temp % 10;
            factSum += fact[lastDigit];
            temp /= 10;
        }

        if(factSum == num){
            System.out.print(num+" is a Strong Number");
        } else {
            System.out.print(num+" is Not a Strong Number");
        }
    }
}
*/