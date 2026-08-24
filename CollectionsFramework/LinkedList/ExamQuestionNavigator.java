/*
#7 Medium ListIterator — bidirectional
-----------------------------------------------------------------------------------------------------------------------------------
Exam question navigator

Store 5 exam questions in a LinkedList. Build a navigator — next() moves to next question, previous() goes back, add question at current
position, remove current question. This uses ListIterator which can move in BOTH directions — something regular Iterator cannot do.
-----------------------------------------------------------------------------------------------------------------------------------
Why LinkedList not ArrayList: ListIterator's add() and remove() during traversal is O(1) in LinkedList — just pointer changes at
current node. Same operations in ArrayList require shifting all elements after current position — O(n). When you need bidirectional
traversal with modification, LinkedList + ListIterator is the combination to use.
-----------------------------------------------------------------------------------------------------------------------------------
Q1→Q2→Q3 (next, next)
current: Q3
previous() → back to Q2
add at current → Q2.5 inserted between Q2 and Q3
next() → Q2.5 | next() → Q3

Skills: ListIterator, hasPrevious(), previous(), it.add(), it.set(), bidirectional traversal, IllegalStateException
Hint at bottom -->
 */

package LinkedList;

public class ExamQuestionNavigator {
    public static void main(String[] args) {

    }
}


/*
ListIterator setup: ListIterator<String> it = questions.listIterator().

Methods:
— it.hasNext() / it.next() — forward
— it.hasPrevious() / it.previous() — backward — unique to ListIterator
— it.add("new question") — inserts at current position
— it.remove() — removes last element returned by next() or previous()
— it.set("updated") — replaces last returned element

Important rule: You must call next() or previous() before calling remove() or set() — otherwise IllegalStateException.
The iterator must have a "current element" to operate on.

Regular Iterator vs ListIterator: Iterator — forward only, can only remove. ListIterator — both directions, can add/set/remove.
Use ListIterator when you need to go back or modify during traversal.
 */