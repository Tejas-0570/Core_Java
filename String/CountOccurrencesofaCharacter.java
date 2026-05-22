import java.util.Scanner;
public class CountOccurrencesofaCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String str = sc.nextLine();
        if(str.isEmpty()){
            System.out.println("ERROR : YOU NEED TO ENTER SOMETHING");
            return;
        }
        System.out.print("Enter a character : ");
        char chr = sc.next().charAt(0);
        int occurrence = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == chr){
                occurrence++;
            }
        }

        System.out.println("Occurrence of "+chr+" : "+occurrence);
    }
}
