import java.util.Scanner;
class DisariumNumber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        int count = 0;
        for(int i = num; i != 0; i /= 10){
            count++;
        }
        int sum = 0;
        for(int i = num; i != 0; i /= 10){
            int ld = i % 10;
            int pow = 1;
            for(int j=1; j<= count; j++){
                pow *= ld;
            }
            sum += pow;
            count--;
        }

        if(num == sum){
            System.out.print(num+" is a Disarium Number");
        } else {
            System.out.print(num+" is Not a Disarium Number");
        }
    }
}


//----------------------------------------- Clean Code ----------------------------------------------------
/*
import java.util.Scanner;
class DisariumNumber{

    static int digitCount(int n){
        int count = 0;
        while(n > 0){
            count++;
            n /= 10;
        }
        return count;
    }

    static int power(int base, int raise){
        int result = 1;
        for(int i = 1; i <= raise; i++){
            result *= base;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        if(!sc.hasNextInt()){
            System.out.print("Invalid Input! Please enter valid input");
            return;
        }
        int num = sc.nextInt();
        if(num < 0) {
            System.out.print("Invalid input! Please enter positive number");
            return;
        }
        if(num == 0){
            System.out.print(num+"is Not a Disarium Number");
            return;
        }

        int count = digitCount(num);
        int sum = 0;

        for(int i = num; i != 0; i /= 10){
            int lastDigit = i % 10;
            sum += power(lastDigit, count);
            count--;
        }

        if(num == sum){
            System.out.print(num+" is a Disarium Number");
        } else {
            System.out.print(num+" is not a Disarium Number");
        }
    }
}


 */