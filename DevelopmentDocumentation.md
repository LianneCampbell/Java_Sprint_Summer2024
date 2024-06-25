# Development Documentation

## Source Code Directory Structure
- `Java_Sprint_Summer2024/`
  - `library/`
    - `LibraryItem.java`
    - `Book.java`
    - `Author.java`
    - `Patron.java`
    - `Library.java`
    - `Borrowable.java`
    - `Status.java`
  - `demo/`
    - `Demo.java`

## Build Process
1. Navigate to the `Java_Sprint_Summer2024/` directory.
2. Navigate to the `demo/` directory.
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