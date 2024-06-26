// Lianne Campbell, Stephen Barnes, Jay Eagles
// LibraryItem.java

package library;

// Abstract class representing a generic item in the library
public abstract class LibraryItem {
    // Fields to store the title and ISBN of the library item
    private String title;
    private String ISBN;

    // Constructor to initialize the title and ISBN of the library item
    public LibraryItem(String title, String ISBN) {
        this.title = title;
        this.ISBN = ISBN;
    }

    // Getter method to retrieve the title of the library item
    public String getTitle() {
        return title;
    }

    // Getter method to retrieve the ISBN of the library item
    public String getISBN() {
        return ISBN;
    }
}