/*
Toggle case
Flip the case of every character — uppercase becomes lowercase, lowercase becomes uppercase.
Leave non-letters unchanged.
Input: "Hello World!"
Output: "hELLO wORLD!"
 */

import java.util.Scanner;
public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("Enter a string : ");
        String str = sc.nextLine();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(!Character.isLetter(ch)){
                sb.append(ch);
                continue;
            }
            if(ch < 91){
                int val = ch+32;
                sb.append((char) val);
            } else {
                int val = ch-32;
                sb.append((char) val);
            }
        }
        System.out.println(sb.toString());
    }
}
