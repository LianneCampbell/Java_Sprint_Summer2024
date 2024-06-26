// Lianne Campbell, Stephen Barnes, Jay Eagles
// Author.java

package library;

import java.util.List;

public class Author {
    // Fields to store the author's name, date of birth, and list of written items
    private String name;
    private String dateOfBirth;
    private List<LibraryItem> writtenItems;

    // Constructor to initialize the author's name, date of birth, and written items
    public Author(String name, String dateOfBirth, List<LibraryItem> writtenItems) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.writtenItems = writtenItems;
    }

    // Getter method to retrieve the author's name
    public String getName() {
        return name;
    }

    // Getter method to retrieve the author's date of birth
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    // Getter method to retrieve the list of items written by the author
    public List<LibraryItem> getWrittenItems() {
        return writtenItems;
    }
}