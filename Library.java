
// Library.java
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> items;
    private List<Author> authors;
    private List<Patron> patrons;

    public Library() {
        this.items = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
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

    public void borrowItem(String isbn, Patron patron) {
        for (LibraryItem item : items) {
            if (item instanceof Borrowable && item.getISBN().equals(isbn)) {
                ((Borrowable) item).borrow(patron);
                patron.getBorrowedItems().add(item);
                System.out.println("Item borrowed: " + item.getTitle());
                return;
            }
        }
        System.out.println("Item not found or not borrowable.");
    }

    public void returnItem(String isbn, Patron patron) {
        for (LibraryItem item : items) {
            if (item instanceof Borrowable && item.getISBN().equals(isbn)) {
                ((Borrowable) item).returnItem(patron);
                patron.getBorrowedItems().remove(item);
                System.out.println("Item returned: " + item.getTitle());
                return;
            }
        }
        System.out.println("Item not found or not returnable.");
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
        for (Author author : authors) {
            if (author.getName().equalsIgnoreCase(authorName)) {
                return author.getWrittenItems();
            }
        }
        return new ArrayList<>();
    }

    public LibraryItem searchItemByISBN(String isbn) {
        for (LibraryItem item : items) {
            if (item.getISBN().equals(isbn)) {
                return item;
            }
        }
        return null;
    }

    public Patron getPatronByName(String name) {
        for (Patron patron : patrons) {
            if (patron.getName().equalsIgnoreCase(name)) {
                return patron;
            }
        }
        return null;
    }

    public List<LibraryItem> getAllItems() {
        return items;
    }

    public List<Author> getAllAuthors() {
        return authors;
    }

    public List<Patron> getAllPatrons() {
        return patrons;
    }
}