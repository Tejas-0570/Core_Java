/*
Pattern 13 :

1 2 3 4
a b c d
5 6 7 8
e f g h

 */

public class Pattern13 {
    public static void main(String[] args) {
        int n = 4, count = 0;
        char ch = 'a';
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i % 2 == 0){
                    System.out.print(++count+" ");
                } else {
                    System.out.print(ch++ +" ");
                }
            }
            System.out.println();
        }
    }
}
