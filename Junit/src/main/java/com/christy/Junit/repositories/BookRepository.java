package com.christy.Junit.repositories;

import com.christy.Junit.domain.Books;

import java.util.List;

public interface BookRepository {
    public String addBook(Books book);
    public List<Books> getAllBooks() throws Exception;
    public Books getBookByBookId(String BookId);
    public List<Books> getBookByName(String keyWord);
}
