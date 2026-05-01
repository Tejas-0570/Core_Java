/*
🔹 Magic Number

Keep summing digits until a single digit. If it becomes 1 → Magic Number

Example:
1729 → 1+7+2+9 = 19 → 1+9 = 10 → 1+0 = 1 ✔️

 */

import java.util.Scanner;
public class MagicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        if(!sc.hasNextInt()){
            System.out.println("Invalid Input! Please enter valid integer");
            return;
        }
        int num = sc.nextInt(); //e.g. 1729
        if (isMagic(num)){
            System.out.println(num+" is a Magic Number");
        }
        else {
            System.out.println(num+" is not a Magic Number");
        }
    }

    public static boolean isMagic(int num){    //1729
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        if(sum == 1) return true;
        if(sum < 10) return false;
        return isMagic(sum);
    }
}
