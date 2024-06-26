// Lianne Campbell, Stephen Barnes, Jay Eagles
// Patron.java

package library;

import java.util.List;

// Class representing a patron (library user) in the library system
public class Patron {
    // Fields to store the patron's name, address, phone number, and list of
    // borrowed items
    private String name;
    private String address;
    private String phoneNumber;
    private List<LibraryItem> borrowedItems;

    // Constructor to initialize the patron's details and borrowed items
    public Patron(String name, String address, String phoneNumber, List<LibraryItem> borrowedItems) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = borrowedItems;
    }

    // Getter method to retrieve the patron's name
    public String getName() {
        return name;
    }

    // Getter method to retrieve the patron's address
    public String getAddress() {
        return address;
    }

    // Getter method to retrieve the patron's phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Getter method to retrieve the list of items borrowed by the patron
    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }
}