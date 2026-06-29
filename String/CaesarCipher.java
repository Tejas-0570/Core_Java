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
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.next().toLowerCase();
        System.out.print("Enter a key : ");
        int key = sc.nextInt();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(!Character.isLetter(ch)){
                encrypted.append(ch);
                continue;
            }
            if(ch == 'z'){
                encrypted.append('c');
            }
            else if(ch == 'y'){
                encrypted.append('b');
            }
            else if(ch == 'x'){
                encrypted.append('a');
            }
            else {
                int val = (int) ch;
                val += key;
                encrypted.append((char)val);
            }
        }
        System.out.println(encrypted);

    }
}
