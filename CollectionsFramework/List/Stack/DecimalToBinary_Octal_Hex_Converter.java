/*
#8 Medium Classic — number conversion

Decimal to Binary/Octal/Hex converter

Convert a decimal number to binary, octal, and hexadecimal using Stack — no Integer.toBinaryString() or built-in conversion allowed.
Divide the number repeatedly, push remainders onto Stack, then pop all remainders — LIFO gives the digits in correct order.
Understand the mathematical pattern Stack solves naturally here.

⚠️ Legacy Stack approach: Stack<Integer> for binary and octal (remainders are 0-7). Stack<String> for hex (remainders can be A-F).
The division-remainder algorithm produces digits in reverse order — last remainder is most significant bit. Stack's LIFO reverses
them back to correct order automatically — no index tracking needed.

✅ Modern replacement — ArrayDeque: Identical algorithm, faster execution. In production code Integer.toBinaryString(),
Integer.toOctalString(), Integer.toHexString() are preferred — single method calls. But the Stack-based manual conversion
teaches the underlying algorithm that applies to ANY base conversion, not just 2, 8, 16.

Input: 13
Binary: 13÷2=6r1, 6÷2=3r0, 3÷2=1r1, 1÷2=0r1 → push 1,0,1,1 → pop → 1101
Octal: 13÷8=1r5, 1÷8=0r1 → push 5,1 → pop → 15
Hex: 13÷16=0r13 → push "D" → pop → D

Skills: division-remainder algorithm, base conversion, LIFO corrects digit order, hex digit mapping, ArrayDeque alternative
Hint at bottom --->
 */

package List.Stack;

public class DecimalToBinary_Octal_Hex_Converter {
    public static void main(String[] args) {

    }
}


/*
Binary conversion — the algorithm:
Stack<Integer> stack = new Stack<>()
while(num > 0) { stack.push(num % 2); num = num / 2; }
while(!stack.isEmpty()) result += stack.pop();
Why Stack? Division gives remainders bottom-up (LSB first). Stack reverses to MSB first. Without Stack you would need an array and reverse it separately.

Octal — base 8: Same algorithm, replace 2 with 8. Remainders 0-7.

Hex — base 16: Remainders 0-15. But 10=A, 11=B, 12=C, 13=D, 14=E, 15=F.
String hexDigits = "0123456789ABCDEF"
Stack<String> stack = new Stack<>()
while(num > 0) { stack.push(String.valueOf(hexDigits.charAt(num % 16))); num /= 16; }

Edge case: if num == 0, result should be "0" — handle before the loop.

Modern ArrayDeque:
Deque<Integer> stack = new ArrayDeque<>() — same algorithm, replace Stack with Deque reference. For production: Integer.toBinaryString(13) → "1101" — one line.
 */