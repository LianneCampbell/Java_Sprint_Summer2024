// Lianne Campbell, Stephen Barnes, Jay Eagles
// Status.java

package library;

// Enum representing the status of a library item
public enum Status {
    // The item is available for borrowing
    AVAILABLE,

    // The item is currently checked out by a patron
    CHECKED_OUT,

    // The item is overdue and should have been returned
    OVERDUE
}