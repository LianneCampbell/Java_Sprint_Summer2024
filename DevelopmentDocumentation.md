# Development Documentation

## Source Code Directory Structure
- `src/`
  - `LibraryItem.java`
  - `Book.java`
  - `Author.java`
  - `Patron.java`
  - `Library.java`
  - `Demo.java`
  - `Borrowable.java`
  - `Status.java`

## Build Process
1. Navigate to the `src` directory.
2. Compile the source files using the command: `javac *.java`.
3. Run the `Demo` class using the command: `java Demo`.

## Compiler Dependencies
- JDK 8 or higher

## Development Standards
- Follow Java naming conventions.
- Use comments to explain complex logic.

## Database Design (Theoretical)
- `Authors`: `id`, `name`, `date_of_birth`
- `Books`: `id`, `title`, `ISBN`, `status`
- `Patrons`: `id`, `name`, `address`, `phone_number`
- `BorrowedItems`: `id`, `patron_id`, `book_id`, `borrow_date`, `return_date`

## Source Code Repository
- Clone the repository from GitHub: `git clone https://github.com/LianneCampbell/Java_Sprint_Summer2024`