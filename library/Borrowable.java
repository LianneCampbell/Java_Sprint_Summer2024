// Lianne Campbell, Stephen Barnes, Jay Eagles
// Borrowable.java

package library;

// Borrowable interface that defines the contract for borrowing and returning items
public interface Borrowable {
    // Method to borrow an item by a patron
    void borrow(Patron patron);

    // Method to return an item by a patron
    void returnItem(Patron patron);
}