import java.util.Scanner;
class NumberCodeUsingMethods{

    // Method for Armstrong Number
    public static boolean isArmStrong(int n){
        int pow = 0;
        int sum = 0;
        for(int i = n ; i != 0; i /= 10){
            pow++;
        }

        for(int i = n; i != 0; i /= 10){
            int ld = i % 10;
            int result = 1;
            for(int j = 0; j < pow; j++){
                result *= ld;
            }
            sum += result;
        }

        return n == sum;

    }


    // Method for Automorphic Number
    public static boolean isAutomorphic(int n){
        int div = 1;
        for(int i = n; i != 0; i /= 10){
            div *= 10;
        }
        int last = (n*n) % div;

        return n == last;
    }


    public static boolean isBuzz(int num){
        return num / 7 == 0 || num % 10 == 7;
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        System.out.println(); // Extra Space after number entered

        // ------------ Method call statement Armstrong Number ------------------
        if(isArmStrong(num)){
            System.out.println(num+" is ARMSTRONG NUMBER\n");
        } else {
            System.out.println(num+" is NOT a ARMSTRONG NUMBER\n");
        }

        //------------- Method call statement for Automorphic Number ---------------
        if(isAutomorphic(num)){
            System.out.println(num+" is AUTOMORPHIC NUMBER\n");
        } else {
            System.out.println(num+" is NOT a AUTOMORPHIC NUMBER\n");
        }

        //------------- Method call statement for Buzz Number ---------------
        if(isBuzz(num)){
            System.out.println(num+" is AUTOMORPHIC NUMBER\n");
        } else {
            System.out.println(num+" is NOT a AUTOMORPHIC NUMBER\n");
        }
    }
}