/*
Pattern 8 :

            * * * * * * *
          * * * * * * *
        * * * * * * *
      * * * * * * *
    * * * * * * *
  * * * * * * *
* * * * * * *


 */

public class Pattern8 {
    public static void main(String[] args) {
        int n = 7;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < (n*2)-i-1; j++){
                if(j < n-i-1){
                    System.out.print(" "+" ");
                } else {
                    System.out.print("*"+" ");
                }
            }
            System.out.println();
        }
    }
}
