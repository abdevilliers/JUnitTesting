package com.christy.Junit.domain;

public class Books {
    public String bookID;
    public String title;
    public String authors;
    public String isbn;
    public String language_code;
    public String ratings_count;
    public String price;
    public String average_rating;
    public Books()
    {

    }

    @Override
    public String toString() {
        return "Books{" +
                "bookID='" + bookID + '\'' +
                ", title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", isbn='" + isbn + '\'' +
                ", language_code='" + language_code + '\'' +
                ", ratings_count='" + ratings_count + '\'' +
                ", price='" + price + '\'' +
                ", average_rating='" + average_rating + '\'' +
                '}';
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public String getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(String ratings_count) {
        this.ratings_count = ratings_count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }

    public Books(String bookID, String title, String authors, String isbn, String language_code, String ratings_count, String price, String average_rating) {
        this.bookID = bookID;
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.language_code = language_code;
        this.ratings_count = ratings_count;
        this.price = price;
        this.average_rating = average_rating;
    }
}
