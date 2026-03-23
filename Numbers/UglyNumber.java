import java.util.Scanner;
public class UglyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        int temp = num;
        while(temp > 1){
            if(temp % 2 == 0) temp /= 2;
            else if(temp % 3 == 0) temp /= 3;
            else if(temp % 5 == 0) temp /= 5;
            else break;
        }
        if(temp == 1){
            System.out.print(num+" is a UGLY NUMBER");
        }
        else {
            System.out.print(num+" is NOT a UGLY NUMBER");
        }
    }
}
