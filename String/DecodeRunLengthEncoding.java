/*
Decode run-length encoding (reverse of #1) :

Given a compressed string, decode it back to the original.
A digit after a character means repeat it that many times.
No digit means it appears once.

Input: "a2b3c2d"
Output: "aabbbccd"
Input: "x3y1z"
Output: "xxxyz"
 */
import java.util.Scanner;
public class DecodeRunLengthEncoding {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter encoded string : ");
        String str = sc.next();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(i+1 < str.length() && Character.isDigit(str.charAt(i+1))){
                int count = Character.getNumericValue(str.charAt(i+1));

                for(int j = 0; j < count; j++){
                    sb.append(ch);
                }
                i++;
            } else {
                sb.append(ch);
            }
        }

        System.out.println("Decoded String : "+sb.toString());
    }
}
