/*
Sort array of 0s, 1s and 2s (Dutch National Flag)

Given an array with only 0s, 1s and 2s, sort it in a single pass without using any sorting method.
Order should be all 0s, then 1s, then 2s.

Input: {2, 0, 1, 2, 0, 1, 1}
Output: {0, 0, 1, 1, 1, 2, 2}
 */

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 2, 0, 1, 1};

        for(int i = 0; i < arr.length; i++){
            int temp;
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
