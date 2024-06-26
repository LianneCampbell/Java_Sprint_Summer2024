// Lianne Campbell, Stephen Barnes, Jay Eagles
// Library.java

package library;

import java.util.ArrayList;
import java.util.List;

// The Library class manages a collection of library items, authors, and patrons.
public class Library {
    // Lists to hold library items, authors, and patrons
    private List<LibraryItem> items;
    private List<Author> authors;
    private List<Patron> patrons;

    // Constructor to initialize the lists
    public Library() {
        this.items = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    // Method to add an item to the library
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    // Method to add an author to the library
    public void addAuthor(Author author) {
        authors.add(author);
    }

    // Method to add a patron to the library
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    // Method to borrow an item from the library by ISBN and patron
    public void borrowItem(String isbn, Patron patron) {
        for (LibraryItem item : items) {
            // Check if the item is borrowable and matches the ISBN
            if (item instanceof Borrowable && item.getISBN().equals(isbn)) {
                ((Borrowable) item).borrow(patron); // Borrow the item
                patron.getBorrowedItems().add(item); // Add the item to the patron's borrowed list
                System.out.println("Item borrowed: " + item.getTitle());
                return;
            }
        }
        System.out.println("Item not found or not borrowable.");
    }

    // Method to return an item to the library by ISBN and patron
    public void returnItem(String isbn, Patron patron) {
        for (LibraryItem item : items) {
            // Check if the item is borrowable and matches the ISBN
            if (item instanceof Borrowable && item.getISBN().equals(isbn)) {
                ((Borrowable) item).returnItem(patron); // Return the item
                patron.getBorrowedItems().remove(item); // Remove the item from the patron's borrowed list
                System.out.println("Item returned: " + item.getTitle());
                return;
            }
        }
        System.out.println("Item not found or not returnable.");
    }

    // Method to search for an item by title
    public LibraryItem searchItemByTitle(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    // Method to search for items by author name
    public List<LibraryItem> searchItemsByAuthor(String authorName) {
        for (Author author : authors) {
            if (author.getName().equalsIgnoreCase(authorName)) {
                return author.getWrittenItems();
            }
        }
        return new ArrayList<>();
    }

    // Method to search for an item by ISBN
    public LibraryItem searchItemByISBN(String isbn) {
        for (LibraryItem item : items) {
            if (item.getISBN().equals(isbn)) {
                return item;
            }
        }
        return null;
    }

    // Method to get a patron by name
    public Patron getPatronByName(String name) {
        for (Patron patron : patrons) {
            if (patron.getName().equalsIgnoreCase(name)) {
                return patron;
            }
        }
        return null;
    }

    // Method to get all library items
    public List<LibraryItem> getAllItems() {
        return items;
    }

    // Method to get all authors
    public List<Author> getAllAuthors() {
        return authors;
    }

    // Method to get all patrons
    public List<Patron> getAllPatrons() {
        return patrons;
    }
}