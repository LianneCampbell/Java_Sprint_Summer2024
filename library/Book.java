// Lianne Campbell, Stephen Barnes, Jay Eagles
// Book.java

package library;

// The Book class extends LibraryItem and implements the Borrowable interface
public class Book extends LibraryItem implements Borrowable {
    // Field to store the current status of the book
    private Status status;

    // Constructor to initialize the book's title, ISBN, and set the initial status
    // to AVAILABLE
    public Book(String title, String isbn) {
        super(title, isbn);
        this.status = Status.AVAILABLE;
    }

    // Method to handle borrowing the book
    @Override
    public void borrow(Patron patron) {
        // Check if the book is available for borrowing
        if (status == Status.AVAILABLE) {
            // If available, set the status to CHECKED_OUT and print a message
            this.status = Status.CHECKED_OUT;
            System.out.println("Book borrowed: " + getTitle());
        } else {
            // If not available, print a message indicating the book is not available
            System.out.println("Book is not available for borrowing.");
        }
    }

    // Method to handle returning the book
    @Override
    public void returnItem(Patron patron) {
        // Check if the book was borrowed
        if (status == Status.CHECKED_OUT) {
            // If it was borrowed, set the status to AVAILABLE and print a message
            this.status = Status.AVAILABLE;
            System.out.println("Book returned: " + getTitle());
        } else {
            // If it was not borrowed, print a message indicating the book was not borrowed
            System.out.println("Book was not borrowed.");
        }
    }

    // Getter method to retrieve the current status of the book
    public Status getStatus() {
        return status;
    }

    // Setter method to set the current status of the book
    public void setStatus(Status status) {
        this.status = status;
    }
}