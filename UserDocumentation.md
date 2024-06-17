# Library Management System

## Overview
This application manages a library of books, authors, and patrons. It allows patrons to borrow and return books.

## Classes and Their Functions
1. **LibraryItem**: An abstract class representing a library item.
2. **Book**: A class representing a book, implements the `Borrowable` interface.
3. **Author**: Represents an author with a name, date of birth, and a list of written items.
4. **Patron**: Represents a library patron with personal details and a list of borrowed items.
5. **Library**: Manages library items, authors, and patrons. Provides methods to search, borrow, and return items.
6. **Demo**: Main class to showcase the library system.
7. **Borrowable**: An interface defining methods to borrow and return items.
8. **Status**: An enum representing the status of a book.

## How to Run the Application
1. Compile all the Java files.
2. Run the `Demo` class.

## Class Diagram
![Class Diagram](class_diagram.png)