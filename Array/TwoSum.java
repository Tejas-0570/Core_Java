/*
Two Sum
Given an array of integers and a target, return indices of the two numbers that add up to target.
Input: [2, 7, 11, 15], target=9 Output: [0, 1] (2+7=9)
 */
import java.util.Scanner;
public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        System.out.println("------------------------- Enter 4 integers -------------------------\n");
        for (int i = 0; i < arr.length; i++){
            System.out.print("Element at index "+i+" : ");
            arr[i] = sc.nextInt();
        }

        System.out.print("\nEnter a target value : ");
        int target = sc.nextInt();
        int cnt = 0;
        for(int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++){
                if (arr[i] + arr[j] == target) {
                    System.out.println("\nOutput : ["+i+", "+j+"]");
                    cnt++;
                }
            }
        }
        if (cnt == 0) {
            System.out.println("Their is no such pair whose addition become "+target);
        }
    }
}
