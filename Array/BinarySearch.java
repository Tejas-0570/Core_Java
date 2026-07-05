import java.util.Scanner;
public class BinarySearch {
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
//        Input: {10, 25, 3, 47, 8}, target = 47
//      ------- Binary Search works on only sorted Array so Sort first ---------
        for(int i = 0; i < arr.length; i++){
            int temp;
            for(int j  = i+1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        int left = 0, right = arr.length-1, mid = 0;
        while(left <= right){
            mid = (left + right)/2;
            if(arr[mid] == target){
                isFound = true;
                System.out.println("Found at index "+mid);
                break;
            } else if (arr[mid] < target){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        if(!isFound){
            System.out.println("Not found");
        }

    }
}
