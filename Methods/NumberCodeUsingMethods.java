import java.util.Scanner;
class NumberCodeUsingMethods{

    //--------------- Common Methods can be used by any other methods -------------------------
    public static int count(int num){
        int count = 0;
        for(int i = num ; i != 0; i /= 10){
            count++;
        }
        return count;
    }
    public static int power(int base, int raise){
        int result = 1;
        while(raise > 0){
            result *= base;
            raise--;
        }
        return result;
    }
//------------------------------------------------------------------------------------------------------------
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


    public static boolean isDisarium(int num){
        int count = count(num);  // count method is called inside isDisarium method
        int sum = 0;
        for(int i = num; i != 0; i /= 10){
            sum += power(i % 10, count); // power method is called inside isDisarium method
            count--;
        }
        return sum == num;
    }


    public static boolean isDuck(int num){
        while(num != 0){  //10345
            if(num % 10 == 0) return true;
            num /= 10;
        }
        return false;
    }


    public static boolean isEven(int num){
        return num % 2 == 0 ;
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
            System.out.println(num+" is BUZZ NUMBER\n");
        } else {
            System.out.println(num+" is NOT a BUZZ NUMBER\n");
        }

        //------------- Method call statement for Disarium Number ---------------
        if(isDisarium(num)){
            System.out.println(num+" is DISARIUM NUMBER\n");
        } else {
            System.out.println(num+" is NOT a DISARIUM NUMBER\n");
        }

        //------------- Method call statement for Duck Number ---------------
        if(isDuck(num)){
            System.out.println(num+" is DUCK NUMBER\n");
        } else {
            System.out.println(num+" is NOT a DUCK NUMBER\n");
        }

        //------------- Method call statement for Even or Odd Number ---------------
        if(isEven(num)){
            System.out.println(num+" is EVEN NUMBER\n");
        } else {
            System.out.println(num+" is ODD NUMBER\n");
        }
    }
}