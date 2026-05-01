/*
Enter a Number excluding zero : 4852541485
Output : 1244455588
 */

import java.util.Scanner;
public class DigitInAscending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number excluding zero : ");
        if(!sc.hasNextLong()){
            System.out.println("Invalid Input! Please enter valid long");
            return;
        }
        long num = sc.nextLong();
        long asce = 0;
        for(int i = 1; i <= 9; i++){
            long temp = num;
            while(temp != 0){
                if(temp % 10 == i){
                    asce = asce * 10 + (temp % 10);
                }
                temp /= 10;
            }
        }

        System.out.println(asce);


    }
}
