// Book.java
public class Book extends LibraryItem implements Borrowable {
    private Status status;

    public Book(String title, String ISBN) {
        super(title, ISBN);
        this.status = Status.AVAILABLE;
    }

    @Override
    public void borrowItem() {
        if (status == Status.AVAILABLE) {
            status = Status.CHECKED_OUT;
            System.out.println("The book has been borrowed.");
        } else {
            System.out.println("Item not available for borrowing.");
        }
    }

    @Override
    public void returnItem() {
        if (status == Status.CHECKED_OUT) {
            status = Status.AVAILABLE;
            System.out.println("The book has been returned.");
        }
    }

    public Status getStatus() {
        return status;
    }
}