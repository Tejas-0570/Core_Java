/*
Pattern 12 :

01  02  03  04
05  06  07  08
09  10  11  12
13  14  15  16


 */


public class Pattern12 {
    public static void main(String[] args) {
        int n = 4, count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(++count < 10){
                   System.out.print("0"+ count+"  ");
                } else {
                    System.out.print(count+"  ");
                }
            }
            System.out.println();
        }
    }
}
