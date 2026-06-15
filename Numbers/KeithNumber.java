import java.util.Scanner;

public class KeithNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a 3 digit number: ");
        int num = sc.nextInt();

        int temp = num;

        int a = temp / 100;
        int b = (temp / 10) % 10;
        int c = temp % 10;

        int sum = 0;

        while (true) {
            sum = a + b + c;

            if (sum == num) {
                System.out.println(num + " is a KEITH NUMBER");
                break;
            }

            if (sum > num) {
                System.out.println(num + " is NOT a KEITH NUMBER");
                break;
            }

            a = b;
            b = c;
            c = sum;
        }
    }
}