/*
Definition : The Fibonacci series is a sequence of numbers where each number
             (Fibonacci number) is the sum of the two preceding ones, usually starting with 0 and 1.
             The sequence typically goes: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, and so on.
 */

// first 10 number of Fibonacci series
class Fibonacci{
    public static void main(String[] args){
        int n1 = 0, n2 = 1, ans;

        for(int i = 1; i <= 10; i++){
            System.out.print(n1+" ");
            ans = n1 + n2;
            n1 = n2;
            n2 = ans;
        }


    }
}

//----------------------------------------------------------------------------------

// Nth Fibonacci Number (e.g. 10th Fibonacci number = 34)
//import java.util.Scanner;
//class Fibonacci{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter Nth Fibonacci Number : ");
//        int Nth = sc.nextInt();
//        int n1 = 0, n2 = 1, ans;
//
//        for(int i = 1; i < Nth; i++){
//            ans = n1 + n2;
//            n1 = n2;
//            n2 = ans;
//        }
//        System.out.print(Nth+" Fibonacci Number is : "+n1);
//    }
//}

//----------------------------------------------------------------------------------

// Fibonacci number between the range (e.g. Fibonacci Number between 20 and 100)
//import java.util.Scanner;
//class Fibonacci{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("----------- Enter the range ---------\n");
//        System.out.print("Enter lower end value : ");
//        int lowerEnd = sc.nextInt();
//        System.out.print("\nEnter higher end value : ");
//        int higherEnd = sc.nextInt();
//        int n1 = 0, n2 = 1, ans;
//
//        if(lowerEnd < higherEnd && lowerEnd > 0){
//            while(true){
//                if(n1>lowerEnd && n1<higherEnd){
//                    System.out.print(n1+" ");
//                }
//                ans = n1 + n2;
//                n1 = n2;
//                n2 = ans;
//
//                if(n1>higherEnd) {
//                    break;
//                }
//            }
//        }else{
//            System.out.print("\nLower end value should less than higher end value and greater than Zero");
//        }
//
//
//    }
//}