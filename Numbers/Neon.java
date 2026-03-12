/*
Neon Number is a number where:
Sum of digits of its square = the number itself
✔ Example
9
Square → 9² = 81
8 + 1 = 9 ✔

1
1² = 1 → sum = 1 ✔

❌ Not Neon
8 → 8² = 64 → 6+4=10 ❌
 */
import java.util.Scanner;
class Neon{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        int sum = 0;

        for(int i = num*num; i > 0; i /= 10){
            sum += i % 10;
        }
        if(num == sum){
            System.out.print(num+" is NEON NUMBER");
        }else{
            System.out.print(num+" is NOT a NEON NUMBER");
        }
    }
}