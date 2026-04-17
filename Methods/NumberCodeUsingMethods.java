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
    public static int Factorial(int num){
        int fact = 1;
        for(int i = num; i > 1; i--){
            fact *= i;
        }
        return fact;
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


    // Method for Buzz Number
    public static boolean isBuzz(int num){
        return num / 7 == 0 || num % 10 == 7;
    }


    // Method for Disarium Number
    public static boolean isDisarium(int num){
        int count = count(num);  // count method is called inside isDisarium method
        int sum = 0;
        for(int i = num; i != 0; i /= 10){
            sum += power(i % 10, count); // power method is called inside isDisarium method
            count--;
        }
        return sum == num;
    }


    // Method for Duck Number
    public static boolean isDuck(int num){
        while(num != 0){  //10345
            if(num % 10 == 0) return true;
            num /= 10;
        }
        return false;
    }


    // Method for Even or Odd Number
    public static boolean isEven(int num){
        return num % 2 == 0 ;
    }


    // Method for Fibonacci Series
    public static void Fibonacci(){
        int n1 = 0, n2 = 1, ans;
        System.out.print("Fibonacci number between 0 to 100 : ");
        while(n1 < 100){
            System.out.print(n1+" ");
            ans = n1 + n2;
            n1 = n2;
            n2 = ans;

        }
    }


    // Method for GCD (Greatest Common Divisor) or HCF (Highest Common Factor)
    public static int GCDorHCF(int num1, int num2){
        int small = num1 < num2 ? num1 : num2; // Math.min(num1, num2);
        if(num1 % small == 0 && num2 % small == 0){
            return small;
        }
        small /= 2;
        while(true){
            if(num1 % small == 0 && num2 % small == 0){
                return small;
            }
            small--;
        }

    }


    // Method for Harshad Number
    public static boolean isHarshadNumber(int num){
        int sum = 0;
        for(int i = num; i != 0; i /= 10){
            sum += num % 10;
        }
        return num == sum;
    }


    // Method for Largest of 3 Number
    public static int LargestOfThreeNumber(int num1, int num2, int num3){
        return num1 > num2 && num1 > num3 ? num1 : (num2 > num3 ? num2 : num3);
    }


    // Method for Least Common Multiplier
    public static int LCM(int num1, int num2){
        int small = num1 < num2 ? num1 : num2;
        while(true){
            if(num1 % small == 0 && num2 % small == 0){
                return small;
            }
            else {
                small /= 2;
                while(true){
                    if(num1 % small == 0 && num2 % small == 0){
                        return small;
                    }
                    small--;
                }
            }
        }
    }


    // Method for Neon Number
    public static boolean isNeon(int num){
        int sum = 0;
        for(int i = num*num; i != 0; i /= 10){
            sum += i % 10;
        }
        return num == sum;
    }


    // Method for Palindrome Number
    public static boolean isPalindrome(int num){
        int rev = 0;
        for(int i = num; i != 0; i /= 10){
            rev = rev * 10 + (i % 10);
        }
        return num == rev;
    }


    // Method for Perfect Number
    public static boolean isPerfect(int num){
        int sum = 0;
        for(int i = 1; i <= num/2; i++){
            if(num % i == 0) sum += i;
        }
        return num == sum;
    }


    // Method for Peterson Number
    public static boolean isPeterson(int num){
        int factSum = 0, temp = num;
        while(num != 0){
            int fact = 1;
            for(int i = num % 10 ; i >= 2; i--){
                fact *= i;
            }
            factSum += fact;
            num /= 10;
        }
        return factSum == temp;
    }


    // Method for Prime Number
    public static boolean isPrime(int num){
        if(num % 2 == 0) return false;
        for(int i = 3; i < num/2; i++){
            if(num % i == 0) {
                return false;
            }
        }
        return true;
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

        //------------- Method call statement for Factorial of Number ---------------
        System.out.println("Factorial of "+num+" = "+Factorial(num)+"\n");

        //------------- Method call statement for Fibonnaci Series ---------------
        Fibonacci();
        System.out.println();

        //------------- Method call statement for GCDorHCF --------------------------------
        System.out.println();
        int num1 = 12, num2 = 18;
        System.out.println("Highest Common Factor of "+num1+" & "+num2+" : "+GCDorHCF(num1, num2));
        System.out.println();

        //------------- Method call statement for Harshad Number ---------------
        int HarshadNo = 81;
        if(isHarshadNumber(HarshadNo)){
            System.out.println(HarshadNo+" is HARSHAD NUMBER\n");
        } else {
            System.out.println(HarshadNo+" is HARSHAD NUMBER\n");
        }

        //------------- Method call statement for Largest of 3 Number ---------------
        System.out.println("Largest of Three is : "+LargestOfThreeNumber(12, 4, 76));
        System.out.println();

        //------------- Method call statement for LCM ---------------
        int n1 = 12, n2 = 18;
        System.out.println("Least Common Multiplier of "+n1+" & "+n2+" is : "+LCM(n1, n2));

        //------------- Method call statement for Neon Number ---------------
        System.out.println();
        int Neon = 9;
        if(isNeon(Neon)){
            System.out.println(Neon+" is a Neon Number");
        } else {
            System.out.println(Neon+" is not a Neon Number");
        }

        //------------- Method call statement for Palindrome Number ---------------
        System.out.println();
        int palindrome = 123321;
        if(isPalindrome(palindrome)){
            System.out.println(palindrome+" is a Palindrome Number");
        } else {
            System.out.println(palindrome+" is not a Palindrome Number");
        }

        //------------- Method call statement for Perfect Number ---------------
        System.out.println();
        int perfect = 6;
        if(isPerfect(perfect)){
            System.out.println(perfect+" is a Perfect Number");
        } else {
            System.out.println(perfect+" is not a Perfect Number");
        }

        //------------- Method call statement for Peterson Number ---------------
        System.out.println();
        int peterson = 145;
        if(isPeterson(peterson)){
            System.out.println(peterson+" is a Peterson Number");
        } else {
            System.out.println(peterson+" is not a Peterson Number");
        }

        //------------- Method call statement for Prime Number ---------------
        System.out.println();
        int prime = 97;
        if(isPrime(prime)){
            System.out.println(prime+" is a Prime Number");
        } else {
            System.out.println(prime+" is not a Prime Number");
        }
    }
}