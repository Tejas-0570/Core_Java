/*
Safe array access

Write a method getElement(int[] arr, int index) that returns the element at index. Handle ArrayIndexOutOfBoundsException and
NullPointerException. Use finally to always print "Access attempt completed." regardless of success or failure.

getElement(arr, 2) → returns element, prints "completed"
getElement(arr, 99) → "Index 99 out of range" then "completed"
getElement(null, 0) → "Array is null" then "completed"

Skills: ArrayIndexOutOfBoundsException, NullPointerException, finally block, exception hierarchy

 */

public class SafeArrayAccess {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int[] arr1 = new int[5];

        getElement(arr, 2);
        System.out.println("-----------------------------------");
        getElement(arr1, 99);
        System.out.println("-----------------------------------");
        getElement(null, 0);
    }

    public static void getElement(int[] arr, int index){
        try{
            System.out.println("Element: "+arr[index]+" --> Completed");
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e){
            System.out.println(e);
        } finally {
            System.out.println("Access attempt completed.");
        }
    }
}
