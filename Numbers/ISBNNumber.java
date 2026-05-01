/*
✅ ISBN-10 Validation Logic

An ISBN-10 number is valid if:

(1×d1 + 2×d2 + 3×d3 + 4×d4 + n×dn ) is divisible by 11

That means:
Sum%11=0

then it is a valid ISBN number.

Example
Take this number : 0201314525

Now multiply each digit by its position:

| Digit | Position |  Multiply |
| ----- | -------: | --------: |
| 0     |        1 |   0×1 = 0 |
| 2     |        2 |   2×2 = 4 |
| 0     |        3 |   0×3 = 0 |
| 1     |        4 |   1×4 = 4 |
| 3     |        5 |  3×5 = 15 |
| 1     |        6 |   1×6 = 6 |
| 4     |        7 |  4×7 = 28 |
| 5     |        8 |  5×8 = 40 |
| 2     |        9 |  2×9 = 18 |
| 5     |       10 | 5×10 = 50 |

Total Sum:
0+4+0+4+15+6+28+40+18+50=165

Now check:

165%11=0

✔️ Therefore, it is a Valid ISBN Number
 */


import java.util.Scanner;

public class ISBNNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        String num = sc.next(); // 0201314525

        int sum = 0;
        for(int i = 0; i <= num.length() - 1; i++){
            sum = sum + ((num.charAt(i) - '0') * (i+1));
        }

        if(sum % 11 == 0){
            System.out.println(num+ " is a ISBN Number");
        } else {
            System.out.println(num+" is not a ISBN Number");
        }

    }



}
