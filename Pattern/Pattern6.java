/*
Pattern 6 : Hour Glass

* * * * * * *
  * * * * *
    * * *
      *
    * * *
  * * * * *
* * * * * * *

 */
public class Pattern6 {
    public static void main(String[] args) {
        int n = 7;
        int star = n, space = 0;
        for (int i = 0; i < n; i++){
            for(int j = 0; j < star; j++){
                if(j < space){
                System.out.print(" "+" ");
                } else {
                    System.out.print("*"+" ");
                }
            }
            System.out.println();
            if(i >= n/2){
                star++;
                space--;
            }
            else {
                star--;
                space++;
            }
        }
    }
}
