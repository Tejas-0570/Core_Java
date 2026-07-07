/*
Find pair with given sum

Find if any two elements in the array add up to a given target sum. Print the pair if found.

Input: {2, 7, 4, 1, 5}, target = 9
Output: Pair found: (2, 7)
Input: target = 20 → No pair found
 */
import java.util.Scanner;
public class FindPairWithGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Array : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print("Enter array element at index "+i+" : ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter target element : ");
        int target = sc.nextInt();
        boolean isFound = true;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(target == arr[i]+arr[j]){
                    isFound = false;
                    System.out.println("Found Pair : ("+arr[i]+", "+arr[j]+")");
//                    return;
                }
            }
        }

        if(isFound){
            System.out.println("Not Found");
        }
    }
}


/*
If you want all pairs, just uncomment return statement
 */