import java.util.Scanner;
class ReverseString{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String str = sc.next();
        String str2 = "";
        for(int i = str.length() - 1; i >= 0 ; i--){
            str2 += str.charAt(i);
        }
        System.out.print("Reverse String : "+str2);
    }
}