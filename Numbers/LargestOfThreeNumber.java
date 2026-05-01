/*
Enter first number : 95
Enter second number : 65
Enter third number : 26
Output : 95
 */

import java.util.Scanner;
public class LargestOfThreeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number : ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number : ");
        int num2 = sc.nextInt();
        System.out.print("Enter third number : ");
        int num3 = sc.nextInt();

        int result = num1>num2 && num1>num3? num1 : (num2 > num3 ? num2 : num3);

        System.out.print(result);
    }
}
