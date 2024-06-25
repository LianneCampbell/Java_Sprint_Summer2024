// Borrowable.java
package library;

public interface Borrowable {
    void borrow(Patron patron);

    void returnItem(Patron patron);
}