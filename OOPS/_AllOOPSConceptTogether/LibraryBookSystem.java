/*
------------------------------------------------------------------------------------------------------------------------
Class & Object + Encapsulation
------------------------------------------------------------------------------------------------------------------------
Library book system

Create a Book class (private: title, author, isAvailable). Methods: borrowBook() sets isAvailable=false if available,
returnBook() sets it back to true, displayStatus() prints current state. Simulate borrowing and returning.

borrowBook() → "You borrowed: Java OOP"
borrowBook() → "Book not available"
returnBook() → "Returned: Java OOP"

Skills: encapsulation, boolean state, method guards, object lifecycle
 */

package _AllOOPSConceptTogether;
public class LibraryBookSystem {
    public static void main(String[] args) {
        Book b1 = new Book("Java OOP", "John Doe");
        b1.borrowBook();
        b1.borrowBook();
        b1.returnBook();

        System.out.println("------------ Status -------------");
        b1.displayStatus();
    }
}

class Book{
    private final String title;
    private final String author;
    private boolean isAvailable ;

    Book(String title, String author){
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

/*
We don't require Setters here, i think someone do this  Book.setAvailability(true) and change so i removed it
//  ----------------- Setters -----------------------
    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setAvailability(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

*/

//  ----------------- Getters -----------------------
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
//  ----------------- Concrete methods -----------------------

    public void borrowBook(){
        if(isAvailable){
            System.out.println("You borrowed: "+title);
            isAvailable = false;
        } else {
            System.out.println("Book is not available");
        }
    }

    public void returnBook(){
        if (!isAvailable) {
            System.out.println("Returned: "+title);
            isAvailable = true;
        } else {
            System.out.println("Book was never borrowed");
        }

    }

    public void displayStatus(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Available: "+(isAvailable ? "Available":"Not Available"));
    }
}
