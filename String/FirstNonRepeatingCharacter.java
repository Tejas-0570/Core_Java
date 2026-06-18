/*
First Non-Repeating Character
Find the first character in a string that does not repeat.
Input: "aabbcde" Output: "c" Input: "aabb" Output: None
*/

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        boolean found = false;
        String str = "aabbcde";
        for(int i = 0; i < str.length(); i++){
           int cnt = 0;
           char temp = str.charAt(i);
           for(int j = 0; j < str.length(); j++){
               if(temp == str.charAt(j)){
                   cnt++;
               }
           }
           if(cnt == 1){
               System.out.println("First non repeating character is : "+temp);
               found = true;
               break;
           }
        }

        if(!found){
            System.out.println("None");
        }

    }
}
