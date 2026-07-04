/*
Count even and odd numbers

Loop through an array and count how many numbers are even and how many are odd.

Input: {1, 2, 3, 4, 5, 6}
Output: Even: 3, Odd: 3
 */
import java.util.Scanner;
public class CountOfEvenAndOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print("Enter array element at index "+i+" : ");
            arr[i] = sc.nextInt();
        }
        int EvenCnt = 0, OddCnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 0){
                EvenCnt++;
            } else {
                OddCnt++;
            }
        }

        System.out.println("Even Count : "+EvenCnt);
        System.out.println("Odd Count  : "+OddCnt);
    }
}
