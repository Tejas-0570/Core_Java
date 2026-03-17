import java.util.Scanner;

class PalindromeNumber{

    static boolean isPalindrome(int n){
        long revNum = 0;
        int original = n;

        while(n > 0){
            revNum = revNum * 10 + (n % 10);
            n /= 10;
        }
        return revNum == original;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        if(!sc.hasNextInt()){
            System.out.print("Invalid Input! Please enter valid input");
            return;
        }
        int num = sc.nextInt();

        if(num < 0){
            System.out.print("Invalid Input! Please enter positive number");
            return;
        }

        if(isPalindrome(num)){
            System.out.print(num+" is a Palindrome Number");
        }
        else{
            System.out.print(num+" is Not a Palindrome Number");
        }
    }
}