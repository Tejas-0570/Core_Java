/*
Second largest element

Find the second largest number in an array. Do it in a single loop — no sorting allowed.

Input: {5, 2, 8, 1, 9, 3}
Output: Second largest: 8
 */


import java.util.Scanner;
public class SecondLargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print("Enter array element at index "+i+" : ");
            arr[i] = sc.nextInt();
        }
//        {1, 2, 5, 3, 4}
        int large = Integer.MIN_VALUE, secondLarge = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > large){
                secondLarge = large;
                large = arr[i];
            } else if (arr[i] > secondLarge && arr[i] != large) {
                secondLarge = arr[i];      // better second found
            }

        }

        if (secondLarge == Integer.MIN_VALUE) {
            System.out.println("No second largest - all elements are equal");
        } else {
            System.out.println("Second largest : " + secondLarge);
        }
    }
}
