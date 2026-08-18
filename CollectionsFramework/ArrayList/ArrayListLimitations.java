/*
ArrayList limitations and when NOT to use it

This problem tests understanding of when ArrayList is NOT the right choice. Build a fixed-size seat booking system for a
10-seat theatre. Prove that: 1) ArrayList CAN be used but is overkill — array is better here. 2) ArrayList of primitives
is not directly possible — must use Integer not int. 3) Converting between array and ArrayList both ways.
4) Measure that accessing by index is O(1) for both.

Seats (array): boolean[10] — booked/available — array is RIGHT here
ArrayList<int>: does NOT compile — must be ArrayList<Integer>
Array→ArrayList: Arrays.asList(arr) or new ArrayList<>(Arrays.asList(arr))
ArrayList→Array: list.toArray(new String[0])

Skills: autoboxing, Arrays.asList(), toArray(), fixed-size list, when array beats ArrayList, O(1) access
Hint at bottom -->
 */

package ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListLimitations {
    public static void main(String[] args){
//      --------------------- 1. Array is better -----------------------------------------------
        boolean[] seats = new boolean[10];   // all false by default = all available

        seats[3] = true;
        seats[7] = true;

        System.out.println("Seat 3 booked? " + seats[3]);
        System.out.println("Seat 5 booked? " + seats[5]);


//      --------------------- 2. ArrayList of primitive is not possible -----------------------------------------------
        // ArrayList<int> seatList = new ArrayList<>();   // COMPILE ERROR — int is a primitive, not a class
        ArrayList<Integer> seatList = new ArrayList<>();   // must use the wrapper class Integer instead
        seatList.add(5);   // autoboxing happens here: int 5 is automatically converted to Integer.valueOf(5)


//      --------------------- Autoboxing and Unboxing -----------------------------------------------
        int primitiveNum = 5;
        Integer boxedNum = primitiveNum;   // autoboxing — implicit int → Integer conversion
        int unboxedBack = boxedNum;        // unboxing — implicit Integer → int conversion
        System.out.println("Boxed: " + boxedNum + " | Unboxed: " + unboxedBack);


//      --------------------- 3. Conversion -----------------------------------------------
        Integer[] seatArray = {1, 2, 3, 4, 5};

        // Array → ArrayList
        ArrayList<Integer> seatArrayList = new ArrayList<>(Arrays.asList(seatArray));
        System.out.println("Converted to ArrayList: " + seatArrayList);
        seatArrayList.add(6);   // this only works because we wrapped it in `new ArrayList<>(...)`
        System.out.println("After adding: " + seatArrayList);

        // ArrayList → Array
        Integer[] backToArray = seatArrayList.toArray(new Integer[0]);
        System.out.println("Converted back to array, length: " + backToArray.length);


        List<Integer> fixedList = Arrays.asList(seatArray);
        try {
            fixedList.add(99);   // Arrays.asList() returns a FIXED-SIZE list — add() should fail
        } catch (UnsupportedOperationException e){
            System.out.println("Confirmed: Arrays.asList() returns a fixed-size list — " + e);
        }

//      ----------------------- 4. Measure that accessing by index is O(1) for both ------------------------
        long start = System.nanoTime();
        boolean seat3 = seats[3];
        long end = System.nanoTime();
        System.out.println("Array access time: " + (end - start) + " ns");

        start = System.nanoTime();
        Integer val = seatArrayList.get(3);
        end = System.nanoTime();
        System.out.println("ArrayList access time: " + (end - start) + " ns");

    }
}


/*
When array beats ArrayList: Fixed known size + primitive type + performance critical = use array. Theatre seats are exactly
10 — no growth needed. boolean[] seats = new boolean[10] is simpler, faster, and uses less memory than ArrayList<Boolean>.

Why ArrayList cannot hold primitives: ArrayList internally uses Object[]. Primitives (int, double, boolean) are not Objects.
Java auto-boxes int → Integer automatically when you write ArrayList<Integer> list and call list.add(5) — 5 becomes new Integer(5).
This boxing/unboxing has a small cost.

Array to ArrayList: String[] arr = {"a","b","c"}; List<String> list = new ArrayList<>(Arrays.asList(arr)); —
wrap Arrays.asList in new ArrayList because Arrays.asList returns fixed-size list — cannot add/remove.

ArrayList to Array: String[] arr = list.toArray(new String[0]); — pass empty array of correct type.

Final rule: Size unknown or changes → ArrayList. Size fixed and known at compile time + primitives → array.
 */