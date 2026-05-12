/*
Pattern 17:
n = 5 | n = 7       | n = 9
      |             |
1     |   1         | 01
2 3   |   2 3       | 02 03
4 5 6 |   4 5 6     | 04 05 06
2 3   |   7 8 9 10  | 07 08 09 10
1     |   4 5 6     | 11 12 13 14 15
      |   2 3       | 07 08 09 10
      |   1         | 04 05 06
      |             | 02 03
      |             | 01
 */

public class Pattern17 {
    public static void main(String[] args) {
        int n = 7, cnt = 1;
        for (int i = 1; i <= n; i++){
            if(i <= (n/2)+1){
                for(int j = 1; j <= i; j++){
                    if(cnt < 10){
                        System.out.print("0"+cnt++ +" ");
                    } else {
                        System.out.print(cnt++ +" ");
                    }
                }
                System.out.println();
            } else {
                cnt = cnt - n;
                for (int k = n/2; k >= 1; k--){
                    if(cnt < 10){
                        System.out.print("0"+cnt++ +" ");
                    } else {
                        System.out.print(cnt++ +" ");
                    }
                }
                System.out.println();
            }

        }

    }
}
