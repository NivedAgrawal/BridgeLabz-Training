package scenerio_based;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom Exception
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// Book Class
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkout() throws BookNotAvailableException {
        if (!isAvailable) {
            throw new BookNotAvailableException("Book is already checked out.");
        }
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Title: " + title +
               ", Author: " + author +
               ", Status: " + (isAvailable ? "Available" : "Checked Out");
    }
}

// Library Manager
class LibraryManager {

    private List<Book> books = new ArrayList<>();

    // Load books from Array
    public void loadBooks(Book[] bookArray) {
        for (Book b : bookArray) {
            books.add(b);
        }
    }

    // Display all books
    public void displayBooks() {
        System.out.println("\n📚 Library Books:");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // Search by partial title
    public void searchBook(String keyword) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with given title.");
        }
    }

    // Checkout book
    public void checkoutBook(String title) throws BookNotAvailableException {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.checkout();
                System.out.println("Book checked out successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Return book
    public void returnBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.returnBook();
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

// Main Class (Menu Driven)
public class LibraryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryManager manager = new LibraryManager();

        // Book Array
        Book[] bookArray = {
            new Book("Java Programming", "James Gosling"),
            new Book("Clean Code", "Robert C. Martin"),
            new Book("Data Structures", "Mark Allen Weiss"),
            new Book("Effective Java", "Joshua Bloch")
        };

        manager.loadBooks(bookArray);

        while (true) {

            System.out.println("\n📖 Library Menu");
            System.out.println("1. Display All Books");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Checkout Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        manager.displayBooks();
                        break;

                    case 2:
                        System.out.print("Enter title keyword: ");
                        manager.searchBook(sc.nextLine());
                        break;

                    case 3:
                        System.out.print("Enter book title to checkout: ");
                        manager.checkoutBook(sc.nextLine());
                        break;

                    case 4:
                        System.out.print("Enter book title to return: ");
                        manager.returnBook(sc.nextLine());
                        break;

                    case 5:
                        System.out.println("Exiting Library System. Goodbye!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (BookNotAvailableException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
