/*
#6 Easy Classic — balanced parentheses
-----------------------------------------------------------------------------------------------------------------------------------
Bracket validator

Given a string containing brackets — (, ), {, }, [, ] — check if they are balanced. Every opening bracket must have a matching
closing bracket in correct order. This is the most commonly asked Stack interview problem. Handle all three bracket types
simultaneously.
-----------------------------------------------------------------------------------------------------------------------------------
⚠️ Legacy Stack approach: Stack<Character> stack = new Stack<>(). Use push() to push opening brackets, pop() to check
matching closing brackets. Stack.peek() to see top without removing. Stack extends Vector — inherits synchronization
overhead even for this purely single-threaded problem.
-----------------------------------------------------------------------------------------------------------------------------------
✅ Modern replacement — ArrayDeque as Stack: Deque<Character> stack = new ArrayDeque<>(). Use push() (addFirst),
pop() (removeFirst), peek() (peekFirst). No synchronization overhead. Java documentation itself recommends ArrayDeque
over Stack class for stack operations. Faster and cleaner.
-----------------------------------------------------------------------------------------------------------------------------------
Input: "{[()]}" → Balanced ✅
Input: "{[(])}" → Not balanced ❌ — wrong order
Input: "(((" → Not balanced ❌ — unclosed
Input: ")))" → Not balanced ❌ — no opening

Skills: push(), pop(), peek(), isEmpty(), bracket matching logic, LIFO thinking, ArrayDeque replacement
Hint at bottom --->
 */


package List.Stack;

import java.util.Scanner;
import java.util.Stack;

public class BracketValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter brackets: ");
        String str = sc.next();

        if(isBalanced(str)){
            System.out.println("Balanced");
        } else {
            System.out.println("Unbalanced");
        }
    }

    public static boolean isBalanced(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                if(ch == ')' && stack.peek() == '('){
                    stack.pop();
                } else if (ch == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (ch == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}


/*
Core logic — the Stack thinking:
Loop through each character of the string.
— If it is an opening bracket ( { [ → push onto stack.
— If it is a closing bracket ) } ] → check top of stack. If stack is empty → unbalanced (no matching opener). If top matches the closing bracket → pop (matched pair found). If top does NOT match → unbalanced (wrong order).
After loop ends — if stack is empty → balanced. If stack has elements → unclosed brackets remain → unbalanced.

Matching logic:
if(ch == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
else if(ch == '}' && !stack.isEmpty() && stack.peek() == '{') stack.pop();
else if(ch == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();
else if(ch==')' || ch=='}' || ch==']') return false; // closing with no match

Legacy Stack: Stack<Character> stack = new Stack<>() — push(), pop(), peek(), isEmpty().

Modern ArrayDeque:
Deque<Character> stack = new ArrayDeque<>()
push() = addFirst() | pop() = removeFirst() | peek() = peekFirst()
Identical logic — just faster, no synchronization cost.
 */
