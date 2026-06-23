import java.util.Scanner;
//---------------------- Normal Answer ------------------------
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
/*

-------------------------- Optimized Answer --------------------------

class ReverseString{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.print("Enter a String : ");
        String str = sc.next();
        for(int i = str.length()-1; i >= 0; i--){
            sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }
}


 */