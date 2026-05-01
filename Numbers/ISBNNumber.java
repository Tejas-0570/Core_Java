import java.util.Scanner;

public class ISBNNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        String num = sc.next(); // 0201314525

        int sum = 0;
        for(int i = 0; i <= num.length() - 1; i++){
            sum = sum + ((num.charAt(i) - '0') * (i+1));
        }

        if(sum % 11 == 0){
            System.out.println(num+ " is a ISBN Number");
        } else {
            System.out.println(num+" is not a ISBN Number");
        }

    }



}
