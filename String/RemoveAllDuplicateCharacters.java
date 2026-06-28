/*
Remove all duplicate characters

Keep only the first occurrence of each character, removing all later duplicates.
Preserve the original order.

Input: "programming"
Output: "progamin"
Input: "banana"
Output: "ban"
 */

import java.util.Scanner;
public class RemoveAllDuplicateCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String (must be lowercase): "); // programming
        String str = sc.next().toLowerCase();
        StringBuilder resultString = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(resultString.toString().indexOf(str.charAt(i)) == -1){
                resultString.append(str.charAt(i));
            }
        }
        System.out.println(resultString);

    }
}
