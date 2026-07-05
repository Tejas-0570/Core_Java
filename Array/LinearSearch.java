/*
Linear search

Search for a target number in an array. Print its index if found, or "Not found" if it doesn't exist.

Input: {10, 25, 3, 47, 8}, target = 47
Output: Found at index 3
Input: target = 99 → Not found
 */

import java.util.Scanner;
public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print("Enter array element at index "+i+" : ");
            arr[i] = sc.nextInt();
        }
        System.out.print("\nEnter target element : ");
        int target = sc.nextInt();
        boolean isFound = false;
        for(int i = 0; i < arr.length; i++){
            if(target == arr[i]){
                isFound = true;
                System.out.println("\nFound at index "+i);
                break;
            }
        }

        if(!isFound){
            System.out.println("\nNot Found");
        }

    }
}
