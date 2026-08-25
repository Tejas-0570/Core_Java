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

import java.util.LinkedList;
import java.util.ListIterator;

public class ExamQuestionNavigator {
    public static void main(String[] args) {
        ExamQuestions eq = new ExamQuestions();

        eq.addQuestion("Q1");
        eq.addQuestion("Q2");
        eq.addQuestion("Q3");

        eq.current();          // Current: Q1

        eq.nextQuestion();     // Next Question: Q2
        eq.nextQuestion();     // Next Question: Q3
        eq.current();          // Current: Q3

        eq.removeCurrent(); // Remove Q3

        eq.previous();         // Previous: Q2
        eq.current();          // Current: Q2

        eq.addAtCurrent("Q2.5");  // inserted between Q2 and Q3
        eq.displayAll();

        eq.nextQuestion();     // Next Question: Q2.5
        eq.nextQuestion();     // Next Question: Q3

        eq.demonstrateIllegalState();  // shows IllegalStateException
    }
}

class ExamQuestions {
    LinkedList<String> questions = new LinkedList<>();
    int currentIndex = 0;

    public void addQuestion(String question){
        questions.addLast(question);
        System.out.println("Question " + question + " added");
    }

    public void nextQuestion(){
        if(currentIndex < questions.size() - 1){
            currentIndex++;
            System.out.println("Next Question: " + questions.get(currentIndex));
        } else {
            System.out.println("No Next");
        }
    }

    public void previous(){
        if(currentIndex > 0){
            currentIndex--;
            System.out.println("Previous: " + questions.get(currentIndex));
        } else {
            System.out.println("No Previous");
        }
    }

    public void current(){
        if(questions.isEmpty()){
            System.out.println("Exam Questions are empty");
            return;
        }
        System.out.println("Current: " + questions.get(currentIndex));
    }

    public void addAtCurrent(String newQuestion){
        ListIterator<String> it = questions.listIterator(currentIndex + 1);
        it.add(newQuestion);
        System.out.println(newQuestion + " inserted after " + questions.get(currentIndex));
    }

    public void removeCurrent(){
        if(questions.isEmpty()){
            System.out.println("Nothing to remove");
            return;
        }
        ListIterator<String> it = questions.listIterator(currentIndex + 1);
        it.previous();   // MUST call next()/previous() before remove() — this selects the current element
        it.remove();
        System.out.println("Removed current question");
        if(currentIndex >= questions.size() && currentIndex > 0){
            currentIndex--;   // clamp back into range if we removed the last element
        }
    }

    public void demonstrateIllegalState(){
        ListIterator<String> it = questions.listIterator();
        try {
            it.remove();   // no next()/previous() called yet — illegal
        } catch (IllegalStateException e){
            System.out.println("Caught: " + e + " — you must call next()/previous() before remove()/set()");
        }
    }

    public void displayAll(){
        System.out.println("All questions: " + questions);
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