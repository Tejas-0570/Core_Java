/*
#2 Easy LinkedList as Stack
---------------------------------------------------------------
Undo-redo system (text editor)

Simulate a simple text editor with undo functionality. Every action the user types gets pushed onto a LinkedList acting as a Stack.
Undo removes the last action. Show current state after each undo. Implement using only push() and pop() — understand LIFO behavior.
-----------------------------------------------------------------------------------------------------------------------------------
Why LinkedList not ArrayList: Stack behavior means always add and remove from the SAME end (top). LinkedList's addFirst/removeFirst
are both O(1). ArrayList's remove(0) is O(n) — has to shift everything. For pure stack operations LinkedList is the natural fit.
-----------------------------------------------------------------------------------------------------------------------------------
type("Hello") → stack: [Hello]
type(" World") → stack: [Hello World, Hello]
type("!!!") → stack: [Hello World!!!, Hello World, Hello]
undo() → removed "Hello World!!!" → current: "Hello World"
undo() → removed "Hello World" → current: "Hello"

Skills: push(), pop(), peek(), LIFO concept, stack behavior, text state tracking
Hint at bottom -->
 */

package LinkedList;

import java.util.LinkedList;

public class UndoRedoSystem {
    public static void main(String[] args) {
        TextEditor t = new TextEditor();

        t.type("Hello");
        t.type(" World");
        t.type("!!!");

        t.undo();
        t.undo();
        t.undo();
        t.undo();

        t.displayStack();
    }
}

class TextEditor{
    LinkedList<String> textEditor = new LinkedList<>();

    public void type(String text){
        if(textEditor.isEmpty()){
            textEditor.push(text);
            System.out.println("Stack: "+textEditor);
            return;
        }
        String newText = textEditor.peek();
        textEditor.push(newText+text);
        System.out.println("Stack: "+textEditor);
    }

    public void undo(){
        if(textEditor.isEmpty()){
            System.out.println("Stack is empty! Can't undo");
            return;
        }
        String removed = textEditor.pop();
        String current = textEditor.peek();
        System.out.println("Removed: "+removed+" | Current: "+(current==null? "Stack is Empty":current));
    }

    public void displayStack(){
        System.out.println("Stack: "+textEditor);
    }


}

/*
Stack with LinkedList: LinkedList<String> undoStack = new LinkedList<>().

push(element): adds to front — same as addFirst(). Stack top = front of LinkedList.

pop(): removes and returns front — same as removeFirst(). Throws EmptyStackException equivalent if empty — check isEmpty() first.

peek(): see top without removing — same as peekFirst().

How to track current text: Each entry in stack is the FULL text state at that point, not just the change. So when you undo,
you pop the top and the new top IS the previous state — no reconstruction needed.

LIFO — Last In First Out: Last action typed is first to be undone. This is exactly Stack behavior — LinkedList implements
it naturally via its front operations.
 */
