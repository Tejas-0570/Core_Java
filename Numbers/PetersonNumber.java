import java.util.Scanner;

class PetersonNumber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        if(!sc.hasNextInt()){
            System.out.print("Invalid input! Please enter valid input");
            return;
        }
        int num = sc.nextInt();
        if(num < 0){
            System.out.print("Invalid input! Please enter positive number");
            return;
        }
        if (num == 0) {
            System.out.println("0 is not considered a Peterson Number.");
            return;
        }

        int factSum = 0;

        for(int i = num; i != 0; i /= 10){
            int fact = 1;
            int ld = i % 10;
            for(int j = ld; j != 0; j--){
                fact = fact * j;
            }
            factSum = factSum + fact;

        }
        if(num == factSum){
            System.out.print(num+" is a Peterson Number");
        }
        else{
            System.out.print(num+" is Not a Peterson Number");
        }
    }
}

/*

// More Optimized version by using Array

import java.util.Scanner;
class PetersonNumber{
    // Pre-compute factorials for digits 0-9 and store in an array
    static int[] preComputeFactorial(){
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
            System.out.print("Invalid input! Please enter valid input");
            return;
        }
        int num = sc.nextInt();

        if(num < 0){
            System.out.print("Invalid input! Please enter positive number");
            return;
        }
        if(num == 0){
            System.out.print("Invalid input! 0 can't be Peterson number");
            return;
        }

        int [] fact = preComputeFactorial();
        int factSum = 0;
        int temp = num;

        while(temp > 0){
            int ld = temp % 10;
            factSum = factSum + fact[ld];
            temp /= 10;
        }

        if(num == factSum){
            System.out.print(num+" is a Peterson Number");
        }
        else{
            System.out.print(num+" is Not a Peterson Number");
        }
    }
}

*/



