import java.util.Scanner;
public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String str = sc.next();
        String revStr = "";

        for(int i = str.length() - 1; i >= 0; i--){
            revStr += str.charAt(i);
        }

        if(str.equals(revStr)){
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
