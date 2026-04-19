/*
Trimorphic Number:
Cube ends with the number itself

Example:
4 → 4³ = 64 ✔️ ends with 4

 */

import java.util.Scanner;
public class TrimorphicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        if(!sc.hasNextInt()){
            System.out.println("Invalid Input! Please enter a valid integer");
            return;
        }
        int num = sc.nextInt();
        if((num*num*num) % pow(num) == num){
            System.out.println(num+" is a Trimorphic Number");
        } else {
            System.out.println(num+" is Not a Trimorphic Number");
        }
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
