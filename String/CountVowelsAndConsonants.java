
//--------------------------- Simple Logic -----------------------
/*
Drawback of this code : It will count ( ❌ spaces, digits, @, # ) as a consonent
If String is Tejas123 then Vowel = 2 and Consonant = 6 here logic breaks
 */
/*
import java.util.Scanner;
public class CountVowelsAndConsonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String str = sc.nextLine().toLowerCase();
        int vowelCount = 0, consonentCount = 0;
        for(int i = 0; i <= str.length()-1; i++){
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            } else {
                consonentCount++;
            }
        }
        System.out.println("Vowel : "+vowelCount);
        System.out.println("Consonant : "+consonentCount);
    }
}
*/

//--------------------------- Optimized Code ------------------------------
/*
What Character.isLetter() does
Character.isLetter('a')   // true  — it's a letter
Character.isLetter('B')   // true  — it's a letter
Character.isLetter(' ')   // false — it's a space
Character.isLetter('3')   // false — it's a digit
Character.isLetter('@')   // false — it's a symbol
 */

import java.util.Scanner;
public class CountVowelsAndConsonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.nextLine().toLowerCase();
        int vowelCount = 0, consonantCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }

        System.out.println("Count of Vowel : " + vowelCount);
        System.out.println("Count of Consonant : " + consonantCount);

    }
}
/*
char ch
    │
    ▼
Character.isLetter(ch)?
    │
    ├── NO  → skip (space, digit, symbol)
    │
    └── YES → is it a, e, i, o, u?
                  ├── YES → vowelCount++
                  └── NO  → consonantCount++
*/