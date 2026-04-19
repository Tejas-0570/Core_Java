/*
Circular Prime:
All rotations of number must be prime

Example:
197 → rotations: 197, 719, 971 ✔️ all prime

 */

import java.util.Scanner;
public class CircularPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        if(!sc.hasNextInt()){
            System.out.println("Invalid Input! Please enter valid integer");
            return;
        }
        int num = sc.nextInt();
        int temp = num, originNum = num;
        while (temp != 0){ //1
            if(isPrime(num)){ //197
                num = rotation(num); //197
            } else {
                System.out.println(originNum+" is Not a Circular Prime Number");
                break;
            }

            if(num == originNum){
                System.out.println(originNum+" is a Circular Prime Number");
            }
            temp /= 10;
        }
    }

    public static boolean isPrime(int num){
        if(num % 2 == 0) return false;
        for(int i = 3; i <= num/2; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static int rotation(int num){
            int ld = num % 10;
            num /= 10;
            num = num + (pow(num) * ld);
        return num;
    }

    public static int pow(int num){
        int pow = 1;
        while(num != 0){
            pow *= 10;
            num /= 10;
        }
        return pow;
    }


}
