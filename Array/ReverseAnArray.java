/*
Reverse an array in place :

Reverse the array without creating a second array — swap elements from both ends moving inward.

Input: {1, 2, 3, 4, 5}
Output: {5, 4, 3, 2, 1}
 */
import java.util.Scanner;
public class ReverseAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an Array Size : ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            System.out.print("Enter array element at index "+i+" : ");
            arr[i] = sc.nextInt();
        }
        for (int i = 0, j = arr.length-1; i < arr.length/2; i++, j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.print("Reverse Array : ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
