/*
Move all zeros to the end

Move all 0s in the array to the end while keeping the order of non-zero elements unchanged.
Do it without a second array.

Input: {0, 1, 0, 3, 12}
Output: {1, 3, 12, 0, 0}
 */

import java.util.Scanner;
public class MoveAllZerosToTheEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {0, 1, 0, 3, 12};
        int insertPos = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                arr[insertPos++] = arr[i];
            }

        }
        for(int i = insertPos; i < arr.length; i++){
            arr[i] = 0;
        }
        System.out.print("Output : ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
