import java.util.Scanner;
class Factorial{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();

        if(num < 0){
            System.out.println("Invalid Input! Please enter positive number");
            return ;
        }
        System.out.println(factorial(num));
    }
//  Factorial program using recursion
    public static int factorial(int num){
        if(num == 0 || num == 1) return 1;
        return num * factorial(num - 1 );
    }
}