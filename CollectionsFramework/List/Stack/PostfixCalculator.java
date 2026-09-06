/*
#9 Hard Classic — postfix expression evaluation
-----------------------------------------------------------------------------------------------------------------------------------
Postfix (Reverse Polish Notation) calculator

Evaluate a postfix expression like "5 3 + 2 *" which means (5+3)*2=16. In postfix, operators come AFTER operands — no brackets needed.
Algorithm: scan left to right, push numbers onto stack, when operator found pop two numbers, apply operator, push result back.
This is how compilers evaluate expressions internally.
-----------------------------------------------------------------------------------------------------------------------------------
⚠️ Legacy Stack approach: Stack<Integer> is perfect for this — push operands, pop when operator found. This is one of the earliest
algorithms taught with Stack data structure (1960s). Every compiler, calculator, and expression parser uses this or infix-to-postfix
conversion internally. Understanding this makes you understand how Java itself evaluates your arithmetic.
-----------------------------------------------------------------------------------------------------------------------------------
✅ Modern replacement — ArrayDeque: Identical algorithm. In real compilers and parsers, expression trees (binary trees) are used for
more complex evaluation with operator precedence, associativity, and function calls. Stack-based postfix evaluation is the foundational
concept that leads to understanding expression trees and parsers.
-----------------------------------------------------------------------------------------------------------------------------------
Input: "5 3 + 2 *"
scan 5 → push 5 stack: [5]
scan 3 → push 3 stack: [5, 3]
scan + → pop 3,5 compute 5+3=8, push 8 → stack: [8]
scan 2 → push 2 stack: [8, 2]
scan * → pop 2,8 compute 8*2=16, push 16 → stack: [16]
Result: 16 ✅

Skills: postfix evaluation, token splitting, pop order for operands, switch on operator, division by zero guard, compiler internals
Hint at bottom --->
 */

package List.Stack;

public class PostfixCalculator {
    public static void main(String[] args) {

    }
}


/*
Core algorithm:
Stack<Integer> stack = new Stack<>()
Split expression by spaces: String[] tokens = expression.split(" ")
Loop through tokens:
— if token is a number: stack.push(Integer.parseInt(token))
— if token is +, -, *, /: pop two values, apply operator, push result.

Pop order matters — CRITICAL:
int b = stack.pop(); // second operand
int a = stack.pop(); // first operand
For "5 3 -" → result should be 5-3=2, NOT 3-5=-2.
b is popped first (top of stack = last pushed = right operand).
a is popped second (bottom = left operand).
Operation is always: a operator b

Switch for operators:
switch(token) {
case "+": stack.push(a + b); break;
case "-": stack.push(a - b); break;
case "*": stack.push(a * b); break;
case "/": if(b==0) throw exception; stack.push(a / b); break;
}
After loop: stack.pop() is the final answer.

Test cases: "2 3 4 + *" → 2*(3+4)=14. "15 7 1 1 + - / 3 * 2 1 1 + + -" → 5.

Modern ArrayDeque:
Deque<Integer> stack = new ArrayDeque<>() — identical algorithm. push()=addFirst, pop()=removeFirst, same logic throughout.
 */