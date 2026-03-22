/*
Pattern 16 :

            1
          1 2 1
        1 2 3 2 1
      1 2 3 4 3 2 1
    1 2 3 4 5 4 3 2 1
  1 2 3 4 5 6 5 4 3 2 1
1 2 3 4 5 6 7 6 5 4 3 2 1

 */

public class Pattern16 {
    public static void main(String[] args) {
        int n = 7, count = 1;
        int space = n-1;
        for(int i = 0; i <  n; i++){
            int digit = 1, rowCounter = 0;
            for(int j = 0; j < space; j++){
                System.out.print(" "+" ");
                rowCounter++;
            }
            space--;
            for(int j = 0; j < count; j++){
                System.out.print(digit+" ");
                rowCounter++;
                if(rowCounter < n){
                    digit++;
                } else {
                    digit--;
                }
            }
            count += 2;
            System.out.println();
        }
    }
}
