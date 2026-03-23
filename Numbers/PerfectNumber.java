import java.util.Scanner;
public class PerfectNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        int sum = 0;
        for(int i = 1; i <= num/2; i++){
            if(num % i == 0) sum += i;
        }
        if(num == sum) System.out.println(num+" is a PERFECT NUMBER");
        else System.out.println(num+" is NOT a PERFECT NUMBER");
    }
}
