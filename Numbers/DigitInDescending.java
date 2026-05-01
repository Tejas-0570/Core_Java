/*
Enter a Number : 14454684125
Output : 86554444211
 */


import java.util.Scanner;
public class DigitInDescending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number : ");
        if(!sc.hasNextLong()){
            System.out.println("Invalid Input! Please enter valid long integer");
            return;
        }
        long num = sc.nextLong();
        long desc = 0;
        for(int i = 9; i >= 1; i--){
            long temp = num;
            while(temp != 0){
                if(temp % 10 == i){
                    desc = desc * 10 + (temp % 10);
                }
                temp /= 10;
            }
        }
        System.out.println(desc);
    }
}
