/*
Automorphic Number is a number where:
Square of the number ends with the same number

✔ Example

5
5² = 25 → ends with 5 ✔

6
6² = 36 → ends with 6 ✔

25
25² = 625 → ends with 25 ✔

76
76² = 5776 → ends with 76 ✔
 */

import java.util.Scanner;
class AutomorphicNumber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        int div = 10, sum = 0;
        while(true){
            int ld = num*num % div;
            if(ld == num){
                System.out.print(num+" is AUTOMORPHIC NUMBER");
                break;
            }
            if(ld > num){
                System.out.print(num+" is NOT a AUTOMORPHIC NUMBER");
                break;
            }
            div *= 10;
        }
    }
}