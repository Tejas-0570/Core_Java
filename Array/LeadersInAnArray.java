/*
Leaders in an array

An element is a "leader" if it is greater than all elements to its right.
The rightmost element is always a leader.

Input: {16, 17, 4, 3, 5, 2}
Output: Leaders: 17, 5, 2
 */
import java.util.Scanner;
public class LeadersInAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of an Array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print("Enter array element at index "+i+" : ");
            arr[i] = sc.nextInt();
        }
        int[] leaders = new int[size];
        int max = Integer.MIN_VALUE, cnt = 0;
        for(int i = arr.length-1; i >= 0; i--){
            if(arr[i] > max){
                max = arr[i];
                leaders[cnt++]= max;
            }
        }

        System.out.print("Leaders : ");
        for(int i = cnt-1; i >= 0; i--){
            System.out.print(leaders[i]+" ");
        }
    }
}
