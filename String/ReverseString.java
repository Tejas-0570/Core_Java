import java.util.Scanner;
class ReverseString{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder newString = new StringBuilder();
        System.out.print("Enter a String : ");
        String str = sc.next();
        for(int i = str.length() - 1; i >= 0 ; i--){
            char ch = str.charAt(i);
            newString.append(ch);
        }
        System.out.print("Reverse String : "+newString);
    }
}