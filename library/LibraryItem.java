// LibraryItem.java
package library;

public abstract class LibraryItem {
    private String title;
    private String ISBN;

    public LibraryItem(String title, String ISBN) {
        this.title = title;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }
}