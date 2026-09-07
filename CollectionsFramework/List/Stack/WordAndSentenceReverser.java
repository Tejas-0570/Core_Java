/*
#7 Easy Classic — reverse using Stack
-----------------------------------------------------------------------------------------------------------------------------------
Word and sentence reverser

Reverse a string word by word AND character by character using Stack — no StringBuilder.reverse() allowed. Push all characters/words
onto stack, then pop them all — LIFO gives reverse order automatically. Understand WHY stack naturally reverses without any index
manipulation.
-----------------------------------------------------------------------------------------------------------------------------------
⚠️ Legacy Stack approach: Stack<String> for word reversal, Stack<Character> for character reversal. Works correctly but Stack's
synchronized methods add unnecessary overhead for this single-threaded string operation. Also Stack.search() method (1-based index
from top) is unique to Stack class — not available in ArrayDeque.
-----------------------------------------------------------------------------------------------------------------------------------
✅ Modern replacement — ArrayDeque: Identical push/pop logic, zero synchronization overhead. For string reversal specifically,
StringBuilder.reverse() is the most efficient real-world approach — but using Stack teaches the LIFO concept that applies to
complex problems like expression evaluation and backtracking.
-----------------------------------------------------------------------------------------------------------------------------------
Input: "Hello World Java"
Word reverse: "Java World Hello"
Char reverse: "avaJ dlroW olleH"
Stack.search(): "Java" found at position 1 from top

Skills: push(), pop(), LIFO reversal concept, split(), toCharArray(), Stack.search(), ArrayDeque alternative
Hint at bottom -->
 */


package List.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class WordAndSentenceReverser {
    public static void main(String[] args) {
        Stack<String> wordStack = new Stack<>();

        String input = "Hello World Java";
        System.out.println("Input : "+input);


        String[] words = input.split(" ");

        for(String w : words){
            wordStack.push(w);
        }
        System.out.println("Search : "+wordStack.search("Java"));

        StringBuilder result = new StringBuilder();
        while(!wordStack.isEmpty()){
            result.append(wordStack.pop()).append(" ");
        }
        System.out.println("Reverse : "+result);

        Stack<Character> charStack = new Stack<>();
        for(Character s : input.toCharArray()){
            charStack.push(s);
        }

        System.out.print("Char Reverse: ");
        while(!charStack.isEmpty()){
            System.out.print(charStack.pop());
        }


        System.out.println("\n--- ArrayDeque equivalent ---");
        Deque<String> wordDeque = new ArrayDeque<>();
        for(String w : words){
            wordDeque.push(w);
        }
        StringBuilder deqResult = new StringBuilder();
        while(!wordDeque.isEmpty()){
            deqResult.append(wordDeque.pop()).append(" ");
        }
        System.out.println("Reverse (ArrayDeque): " + deqResult.toString().trim());

// wordDeque.search("Java");  // does NOT exist on ArrayDeque/Deque — Stack-only method
        System.out.println("Contains 'Java'? " + wordDeque.contains("Java"));  // ArrayDeque's alternative
    }
}


/*
Word reversal using Stack:
Stack<String> wordStack = new Stack<>()
Split input: String[] words = input.split(" ")
Push all words: for(String w : words) wordStack.push(w)
Pop all words: while(!wordStack.isEmpty()) result += wordStack.pop() + " "
LIFO guarantees last word pushed (last word in sentence) pops first — natural reversal.

Character reversal using Stack:
Stack<Character> charStack = new Stack<>()
Loop: for(char c : input.toCharArray()) charStack.push(c)
Pop: while(!charStack.isEmpty()) result += charStack.pop()

Stack.search() — Stack-only method:
wordStack.search("Java") — returns 1-based position from top. Returns -1 if not found. Position 1 = top. This method does NOT exist in ArrayDeque — one reason Stack is still taught.

Modern ArrayDeque:
Deque<String> stack = new ArrayDeque<>()
Same push/pop logic. No search() method — use contains() instead for existence check.
 */