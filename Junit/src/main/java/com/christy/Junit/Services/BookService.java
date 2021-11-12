package com.christy.Junit.Services;

import com.christy.Junit.domain.Books;

import java.util.List;

public interface BookService {

    public String addBook(Books book) throws Exception;
    public List<Books> getAllBooks() throws Exception;
    public Books getBookByBookId(String bookId) throws Exception;
    public List<Books> getBooksByName(String keyWord) throws Exception;
}
