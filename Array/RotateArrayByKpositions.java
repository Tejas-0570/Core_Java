/*
Rotate array by K positions

Rotate an array to the right by K steps. The last K elements wrap around to the front.

Input: {1, 2, 3, 4, 5}, K=2
Output: {4, 5, 1, 2, 3}
 */
import java.util.Scanner;
public class RotateArrayByKpositions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print("Enter array element at index "+i+" : ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter K (Rotation) : ");
        int k = sc.nextInt();

        k = k % arr.length;

        int[] rotatedArray = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            int newPosition = (i + k) % arr.length;
            rotatedArray[newPosition] = arr[i];
        }
        System.out.print("Rotated Array : { ");
        for(int i = 0; i < size; i++){
            System.out.print(rotatedArray[i]+" ");
        }
        System.out.print("}");
    }
}


/*
What does "rotate right by K" mean?
Original : {1, 2, 3, 4, 5}   K=2

Think of it as a circle — last K elements wrap to front

{1, 2, 3, 4, 5}
         ↑  ↑
     these 2 come to front

Result   : {4, 5, 1, 2, 3}

The key formula — where does each element go?
Every element at index i moves to index (i + K) % length in the new array.
Let me show why with K=2, length=5:

index 0 → (0+2) % 5 = 2   →  1 goes to position 2
index 1 → (1+2) % 5 = 3   →  2 goes to position 3
index 2 → (2+2) % 5 = 4   →  3 goes to position 4
index 3 → (3+2) % 5 = 0   →  4 goes to position 0  ← wrap!
index 4 → (4+2) % 5 = 1   →  5 goes to position 1  ← wrap!

new array : {4, 5, 1, 2, 3} ✅

Why K = K % length first?
Array length = 5,  K = 7

Rotating 5 times = back to original — pointless
So effective rotation = 7 % 5 = 2

K=7 and K=2 give exact same result
Always reduce K first to avoid unnecessary work
 */
