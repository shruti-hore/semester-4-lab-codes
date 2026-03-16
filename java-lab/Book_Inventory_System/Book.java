package Book_Inventory_System;

public class Book {

    private String title;
    private String author;
    private String genre;
    private double price;

    public Book(String title, String author, String genre, double price) 
            throws InvalidPriceException {

        if (price < 0) {
            throw new InvalidPriceException("Price cannot be negative.");
        }

        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    // Method to return formatted row
    public String toTableRow() {
        return String.format("%-20s %-20s %-15s $%-10.2f",
                title, author, genre, price);
    }
}