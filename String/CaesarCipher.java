/*
Caesar cipher — encrypt & decrypt

Shift each letter forward by a given number (key). Wrap around after 'z'.
Non-letters stay unchanged. Also write the decryption (shift backward).

Input: "hello", key=3
Encrypt: "khoor"
Decrypt: "hello"
 */

import java.util.Scanner;
public class CaesarCipher {
    public static void main(String[] args) {
        StringBuilder encrypted = new StringBuilder();
        StringBuilder decrypted = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.next().toLowerCase();
        System.out.print("Enter a key : ");
        int key = sc.nextInt();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(!Character.isLetter(ch)){
                encrypted.append(ch);
                decrypted.append(ch);
                continue;
            }
            char enc = (char)(((ch-'a'+key)%26)+ 'a');
            char dec = (char)(((enc-'a'-key+26)%26)+'a');

            encrypted.append(enc);
            decrypted.append(dec);
        }
        System.out.println("Original String : "+str);
        System.out.println("Encrypted String : "+encrypted);
        System.out.println("Decrypted String : "+decrypted);
    }
}