
// Author.java
package library;

import java.util.List;

public class Author {
    private String name;
    private String dateOfBirth;
    private List<LibraryItem> writtenItems;

    public Author(String name, String dateOfBirth, List<LibraryItem> writtenItems) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.writtenItems = writtenItems;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public List<LibraryItem> getWrittenItems() {
        return writtenItems;
    }
}