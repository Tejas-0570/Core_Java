import java.util.Locale;
import java.util.Scanner;
public class CountVowelsAndConsonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String str = sc.next().toLowerCase();
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
