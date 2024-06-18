
// Library.java
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> items;
    private List<Author> authors;
    private List<Patron> patrons;

    public Library() {
        items = new ArrayList<>();
        authors = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public LibraryItem searchItemByTitle(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    public List<LibraryItem> searchItemsByAuthor(String authorName) {
        List<LibraryItem> result = new ArrayList<>();
        for (Author author : authors) {
            if (author.getName().equalsIgnoreCase(authorName)) {
                result.addAll(author.getWrittenItems());
            }
        }
        return result;
    }

    public LibraryItem searchItemByISBN(String ISBN) {
        for (LibraryItem item : items) {
            if (item.getISBN().equals(ISBN)) {
                return item;
            }
        }
        return null;
    }

    public void borrowItem(String ISBN, Patron patron) {
        LibraryItem item = searchItemByISBN(ISBN);
        if (item != null && item instanceof Borrowable) {
            ((Borrowable) item).borrowItem();
            patron.getBorrowedItems().add(item);
        }
    }

    public void returnItem(String ISBN, Patron patron) {
        LibraryItem item = searchItemByISBN(ISBN);
        if (item != null && item instanceof Borrowable) {
            ((Borrowable) item).returnItem();
            patron.getBorrowedItems().remove(item);
        }
    }
}