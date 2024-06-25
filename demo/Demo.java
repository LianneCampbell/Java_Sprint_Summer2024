package demo;

import library.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeLibrary();
        displayMenu();
    }

    private static void initializeLibrary() {
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
        List<LibraryItem> patron1BorrowedItems = new ArrayList<>();
        List<LibraryItem> patron2BorrowedItems = new ArrayList<>();

        Patron patron1 = new Patron("John Doe", "123 Main St", "555-1234", patron1BorrowedItems);
        Patron patron2 = new Patron("Jane Smith", "456 Elm St", "555-5678", patron2BorrowedItems);

        library.addPatron(patron1);
        library.addPatron(patron2);
    }

    private static void displayMenu() {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Author");
            System.out.println("3. Add Patron");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Search Book by Title");
            System.out.println("7. Search Book by Author");
            System.out.println("8. Search Book by ISBN");
            System.out.println("9. Display All Books");
            System.out.println("10. Display All Authors");
            System.out.println("11. Display All Patrons");
            System.out.println("12. Display Borrowed Books by Patron");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addAuthor();
                    break;
                case 3:
                    addPatron();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    searchBookByTitle();
                    break;
                case 7:
                    searchBookByAuthor();
                    break;
                case 8:
                    searchBookByISBN();
                    break;
                case 9:
                    displayAllBooks();
                    break;
                case 10:
                    displayAllAuthors();
                    break;
                case 11:
                    displayAllPatrons();
                    break;
                case 12:
                    displayBorrowedBooksByPatron();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, isbn);
        library.addItem(book);
        System.out.println("Book added successfully.");
    }

    private static void addAuthor() {
        System.out.print("Enter author name: ");
        String name = scanner.nextLine();
        System.out.print("Enter author date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        Author author = new Author(name, dob, new ArrayList<>());
        library.addAuthor(author);
        System.out.println("Author added successfully.");
    }

    private static void addPatron() {
        System.out.print("Enter patron name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patron address: ");
        String address = scanner.nextLine();
        System.out.print("Enter patron phone number: ");
        String phoneNumber = scanner.nextLine();

        Patron patron = new Patron(name, address, phoneNumber, new ArrayList<>());
        library.addPatron(patron);
        System.out.println("Patron added successfully.");
    }

    private static void borrowBook() {
        System.out.print("Enter patron name: ");
        String patronName = scanner.nextLine();
        Patron patron = library.getPatronByName(patronName);
        if (patron == null) {
            System.out.println("Patron not found.");
            return;
        }

        System.out.print("Enter book ISBN to borrow: ");
        String isbn = scanner.nextLine();
        library.borrowItem(isbn, patron);
    }

    private static void returnBook() {
        System.out.print("Enter patron name: ");
        String patronName = scanner.nextLine();
        Patron patron = library.getPatronByName(patronName);
        if (patron == null) {
            System.out.println("Patron not found.");
            return;
        }

        System.out.print("Enter book ISBN to return: ");
        String isbn = scanner.nextLine();
        library.returnItem(isbn, patron);
    }

    private static void searchBookByTitle() {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();
        LibraryItem item = library.searchItemByTitle(title);
        if (item != null) {
            System.out.println("Book found: " + item.getTitle() + " (ISBN: " + item.getISBN() + ")");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void searchBookByAuthor() {
        System.out.print("Enter author name to search: ");
        String authorName = scanner.nextLine();
        List<LibraryItem> items = library.searchItemsByAuthor(authorName);
        if (!items.isEmpty()) {
            System.out.println("Books by " + authorName + ":");
            for (LibraryItem item : items) {
                System.out.println("- " + item.getTitle() + " (ISBN: " + item.getISBN() + ")");
            }
        } else {
            System.out.println("No books found for author " + authorName);
        }
    }

    private static void searchBookByISBN() {
        System.out.print("Enter book ISBN to search: ");
        String isbn = scanner.nextLine();
        LibraryItem item = library.searchItemByISBN(isbn);
        if (item != null) {
            System.out.println("Book found: " + item.getTitle() + " (ISBN: " + item.getISBN() + ")");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void displayAllBooks() {
        List<LibraryItem> items = library.getAllItems();
        System.out.println("All books in the library:");
        for (LibraryItem item : items) {
            System.out.println("- " + item.getTitle() + " (ISBN: " + item.getISBN() + ")");
        }
    }

    private static void displayAllAuthors() {
        List<Author> authors = library.getAllAuthors();
        System.out.println("All authors in the library:");
        for (Author author : authors) {
            System.out.println("- " + author.getName() + " (DOB: " + author.getDateOfBirth() + ")");
        }
    }

    private static void displayAllPatrons() {
        List<Patron> patrons = library.getAllPatrons();
        System.out.println("All patrons in the library:");
        for (Patron patron : patrons) {
            System.out.println("- " + patron.getName() + " (Address: " + patron.getAddress() + ", Phone: "
                    + patron.getPhoneNumber() + ")");
        }
    }

    private static void displayBorrowedBooksByPatron() {
        System.out.print("Enter patron name: ");
        String patronName = scanner.nextLine();
        Patron patron = library.getPatronByName(patronName);
        if (patron == null) {
            System.out.println("Patron not found.");
            return;
        }

        List<LibraryItem> borrowedItems = patron.getBorrowedItems();
        if (!borrowedItems.isEmpty()) {
            System.out.println("Books borrowed by " + patronName + ":");
            for (LibraryItem item : borrowedItems) {
                System.out.println("- " + item.getTitle() + " (ISBN: " + item.getISBN() + ")");
            }
        } else {
            System.out.println(patronName + " has not borrowed any books.");
        }
    }
}