// Book.java
package library;

public class Book extends LibraryItem implements Borrowable {
    private Status status;

    public Book(String title, String isbn) {
        super(title, isbn);
        this.status = Status.AVAILABLE;
    }

    @Override
    public void borrow(Patron patron) {
        if (status == Status.AVAILABLE) {
            this.status = Status.CHECKED_OUT;
            System.out.println("Book borrowed: " + getTitle());
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    @Override
    public void returnItem(Patron patron) {
        if (status == Status.CHECKED_OUT) {
            this.status = Status.AVAILABLE;
            System.out.println("Book returned: " + getTitle());
        } else {
            System.out.println("Book was not borrowed.");
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}