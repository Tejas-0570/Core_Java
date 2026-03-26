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



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();

        // ------------ Method call statement Armstrong Number ------------------
        boolean Armstrong = isArmStrong(num);
        if(Armstrong){
            System.out.println(num+" is ARMSTRONG NUMBER");
        } else {
            System.out.println(num+" is NOT a ARMSTRONG NUMBER");
        }

        //------------- Method call statement for Automorphic Number ---------------
        boolean Automorphic = isAutomorphic(num);
        if(Automorphic){
            System.out.println(num+" is AUTOMORPHIC NUMBER");
        } else {
            System.out.println(num+" is NOT a AUTOMORPHIC NUMBER");
        }
    }
}