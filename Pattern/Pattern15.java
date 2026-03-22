/*
Pattern 15 :

01 05 09 13
02 06 10 14
03 07 11 15
04 08 12 16

 */

public class Pattern15 {
    public static void main(String[] args) {
        int n = 4, ptr = 1;
        for(int i = 1; i <= n; i++, ptr++){
            int val = ptr;
            for(int j = 1; j <= n; j++){
                if(i == ptr && j == 1){
                    if(val < 10) System.out.print("0"+val+" ");
                    else System.out.print(val+" ");
                    val += 4;
                } else {
                    if(val < 10) System.out.print("0"+val+" ");
                    else System.out.print(val+" ");
                    val += 4;
                }
            }
            System.out.println();
        }
    }
}
