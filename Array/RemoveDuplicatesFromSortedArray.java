/*
Remove duplicates from sorted array

Given a sorted array, remove duplicate elements and print only unique values.
No collections allowed.

Input: {1, 1, 2, 3, 3, 4, 5, 5}
Output: {1, 2, 3, 4, 5}
 */


public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 5, 5};
        System.out.print("Output : {"+arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i-1]){
                System.out.print(" "+arr[i]);
            }
        }
        System.out.println("}");

    }
}
