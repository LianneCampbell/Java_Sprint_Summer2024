//Demo

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Library library = new Library();

        // Create authors
        List<LibraryItem> author1Books = new ArrayList<>();
        List<LibraryItem> author2Books = new ArrayList<>();
        List<LibraryItem> author3Books = new ArrayList<>();

        Author author1 = new Author("Author One", "1970-01-01", author1Books);
        Author author2 = new Author("Author Two", "1980-01-01", author2Books);
        Author author3 = new Author("Author Three", "1990-01-01", author3Books);

        // Create books
        Book book1 = new Book("Book One", "ISBN001");
        Book book2 = new Book("Book Two", "ISBN002");
        Book book3 = new Book("Book Three", "ISBN003");
        Book book4 = new Book("Book Four", "ISBN004");
        Book book5 = new Book("Book Five", "ISBN005");

        // Assign books to authors
        author1Books.add(book1);
        author1Books.add(book2);
        author2Books.add(book3);
        author3Books.add(book4);
        author3Books.add(book5);

        // Add authors and books to the library
        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addAuthor(author3);
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(book4);
        library.addItem(book5);

        // Create patrons
        List<LibraryItem> patronBorrowedItems = new ArrayList<>();
        Patron patron1 = new Patron("John Doe", "123 Main St", "555-1234", patronBorrowedItems);
        Patron patron2 = new Patron("Jane Smith", "456 Elm St", "555-5678", new ArrayList<>());

        library.addPatron(patron1);
        library.addPatron(patron2);

        System.out.println("Library system initialized.\n");

        // Showcase borrowing books
        System.out.println("Patron 1 borrowing books:");
        library.borrowItem("ISBN001", patron1);
        library.borrowItem("ISBN002", patron1);
        library.borrowItem("ISBN003", patron1);
        System.out.println();

        // Show borrowed items by patron1
        System.out.println("Patron 1 borrowed items:");
        for (LibraryItem item : patron1.getBorrowedItems()) {
            System.out.println(" - " + item.getTitle() + " (ISBN: " + item.getISBN() + ")");
        }
        System.out.println();

        // Showcase returning a book
        System.out.println("Patron 1 returning a book:");
        library.returnItem("ISBN001", patron1);
        System.out.println();

        // Show borrowed items by patron1 after returning a book
        System.out.println("Patron 1 borrowed items after returning a book:");
        for (LibraryItem item : patron1.getBorrowedItems()) {
            System.out.println(" - " + item.getTitle() + " (ISBN: " + item.getISBN() + ")");
        }
        System.out.println();

        // Show book statuses
        System.out.println("Book statuses:");
        System.out.println("Book One: " + book1.getStatus());
        System.out.println("Book Two: " + book2.getStatus());
        System.out.println("Book Three: " + book3.getStatus());
        System.out.println("Book Four: " + book4.getStatus());
        System.out.println("Book Five: " + book5.getStatus());
        System.out.println();

        // Showcase searching for books by title
        System.out.println("Searching for books by title 'Book Three':");
        LibraryItem searchedByTitle = library.searchItemByTitle("Book Three");
        if (searchedByTitle != null) {
            System.out.println("Found: " + searchedByTitle.getTitle() + " (ISBN: " + searchedByTitle.getISBN() + ")");
        } else {
            System.out.println("Book not found.");
        }
        System.out.println();

        // Showcase searching for books by author
        System.out.println("Searching for books by author 'Author Three':");
        List<LibraryItem> searchedByAuthor = library.searchItemsByAuthor("Author Three");
        if (!searchedByAuthor.isEmpty()) {
            for (LibraryItem item : searchedByAuthor) {
                System.out.println("Found: " + item.getTitle() + " (ISBN: " + item.getISBN() + ")");
            }
        } else {
            System.out.println("No books found for the author.");
        }
        System.out.println();

        // Showcase searching for books by ISBN
        System.out.println("Searching for books by ISBN 'ISBN005':");
        LibraryItem searchedByISBN = library.searchItemByISBN("ISBN005");
        if (searchedByISBN != null) {
            System.out.println("Found: " + searchedByISBN.getTitle() + " (ISBN: " + searchedByISBN.getISBN() + ")");
        } else {
            System.out.println("Book not found.");
        }
        System.out.println();
    }
}