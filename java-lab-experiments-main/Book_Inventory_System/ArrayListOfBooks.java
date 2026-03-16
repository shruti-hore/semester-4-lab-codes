package Book_Inventory_System;

import java.util.ArrayList;

public class ArrayListOfBooks {

    public static void main(String[] args) {

        ArrayList<Book> bookList = new ArrayList<>();

        try {

            Book b1 = new Book("Harry Potter", "J.K. Rowling", "Fiction", 500);
            Book b2 = new Book("The Alchemist", "Paulo Coelho", "Fiction", 400);
            Book b3 = new Book("Java Programming", "James Gosling", "Tech", 800);
            Book b4 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki", "Non-Fiction", 350);

            bookList.add(b1);
            bookList.add(b2);
            bookList.add(b3);
            bookList.add(b4);

            // Trying negative price
            Book b5 = new Book("Invalid Book", "Unknown", "Fiction", -100);
            bookList.add(b5);

        } catch (InvalidPriceException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        // display books
        System.out.println("\n================ BOOK LIST ================");
        System.out.printf("%-20s %-20s %-15s %-10s\n",
                "TITLE", "AUTHOR", "GENRE", "PRICE");
        System.out.println("---------------------------------------------------------------");

        bookList.forEach(book -> System.out.println(book.toTableRow()));

        // calculate average price
        double total = 0;
        for (Book b : bookList) {
            total += b.getPrice();
        }

        double average = total / bookList.size();
        System.out.printf("\nAverage Price: $%.2f\n", average);

        // to display only fiction books
        System.out.println("\n=========== FICTION BOOKS ===========");
        System.out.printf("%-20s %-20s %-15s %-10s\n",
                "TITLE", "AUTHOR", "GENRE", "PRICE");
        System.out.println("---------------------------------------------------------------");

        bookList.forEach(book -> {
            if (book.getGenre().equalsIgnoreCase("Fiction")) {
                System.out.println(book.toTableRow());
            }
        });
    }

}
