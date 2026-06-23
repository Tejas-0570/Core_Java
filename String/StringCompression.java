/*
String Compression :
Compress a string so repeated characters are written as character + count.
But if a character appears only once, don't write the count — just the character.
Input: "aabbbccd"
Output: "a2b3c2d"
Input: "abc"
Output: "abc"
 */
//--------------------------- My Answer ------------------------

public class StringCompression {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String str = "aabbbccd";
        int counter = 0;
        for(int i = 0; i < str.length(); i += counter){
            int cnt = 0;
            char temp = str.charAt(i);
            for(int j = i; j < str.length(); j++){
                if(temp == str.charAt(j)){
                    cnt++;
                } else {
                    break;
                }
            }
            if(cnt > 1){
                sb.append(str.charAt(i)+""+cnt);
            } else {
                sb.append(str.charAt(i));
            }

            counter = cnt;

        }
        System.out.println(sb.toString());
    }
}



/*

//--------------------------- AI Answer ------------------------
 public class StringCompression{
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String str = "aabbbccccd";
        int i = 0;
        while(i < str.length()){
            char current = str.charAt(i);
            int cnt = 0;
             while(i < str.length() && current==str.charAt(i)){
                 cnt++;
                 i++;
             }

             if(cnt > 1){
                 sb.append(current).append(cnt);
             } else {
                 sb.append(current);
             }
        }
        System.out.println(sb.toString());
    }
}

 */