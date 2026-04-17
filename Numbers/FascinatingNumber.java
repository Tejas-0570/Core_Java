/*
Fascinating Number (Short Definition):
A fascinating number is a number where, when multiplied by 1, 2 and 3 and all results are concatenated,
the resulting number contains all digits from 1 to 9 exactly once.

✅ Example: 192

Check:
192 × 2 = 384
192 × 3 = 576

Concatenate → 192384576

✔️ This contains digits 1 to 9 exactly once
✔️ So, 192 is a Fascinating number
 */


import java.util.Scanner;
public class FascinatingNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        if (!sc.hasNextLong()) {
            System.out.println("Invalid input! Please enter a valid integer.");
            return;
        }
        long num = sc.nextLong();
        if(num < 0){
            System.out.println("Invalid Input, Please enter positive number");
            return;
        }
        if(num < 100 || num > 999){
            System.out.println("Invalid Input! Number must be of 3 digit");
            return;
        }
        long temp = num;

        while(temp != 0){
            if(temp % 10 == 0){
                System.out.println(num+" is Not a Fascinating Number");
                return;
            }
            temp /= 10;
        }

        if(isFascinating(num)){
            System.out.println(num+" is a Fascinating Number");
        } else {
            System.out.println(num+" is Not a Fascinating Number");
        }
    }

    // Method for isFascinating Number
    public static boolean isFascinating(long num){
        long mergedNum = merge(num);
        return frequency(mergedNum);
    }

    public static long merge(long num){
        long merge = num; //192
              // 192  * pow(384) + 384
        merge = merge * pow(num * 2) + num*2;  //192384
              //192384 * pow(576) +  576
        merge = merge * pow(num * 3) + num*3; //192384576
        return merge;
    }

    public static long pow(long num){
        int pow = 1;
        while(num != 0){
            pow *= 10;
            num /= 10;
        }
        return pow;
    }

    public static boolean frequency(long num){
        int one=0, two=0, three=0, four=0, five=0, six=0, seven=0, eight=0, nine=0;
        while(num != 0){
            long ld = num % 10;
            if(ld == 1) {
                one++;
            }
            else if (ld == 2) {
                two++;
            }
            else if (ld == 3) {
                three++;
            }
            else if (ld == 4) {
                four++;
            }
            else if (ld == 5) {
                five++;
            }
            else if (ld == 6) {
                six++;
            }
            else if (ld == 7) {
                seven++;
            }
            else if (ld == 8) {
                eight++;
            } else {
                nine++;
            }
            num /= 10;
        }

        return one == 1 && two == 1 && three == 1 && four == 1 && five == 1 && six == 1 && seven == 1 && eight == 1 && nine == 1;

    }
}
