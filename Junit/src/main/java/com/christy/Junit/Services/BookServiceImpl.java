package com.christy.Junit.Services;

import com.christy.Junit.domain.Books;
import com.christy.Junit.exceptions.RecordNotFoundException;
import com.christy.Junit.exceptions.TitleNotFoundException;
import com.christy.Junit.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public String addBook(Books book) throws Exception {

        return bookRepository.addBook(book);


    }

    @Override
    public List<Books> getAllBooks() throws Exception {
        List<Books> setOfBooks=new ArrayList<>();
        setOfBooks=bookRepository.getAllBooks();
        if( setOfBooks==null || setOfBooks.size()==0)
        {
            throw new RecordNotFoundException();
        }
        return setOfBooks;
    }

    @Override
    public Books getBookByBookId(String bookId) throws Exception{
        Books setOfBooks=null;
        setOfBooks=bookRepository.getBookByBookId(bookId);

        if( setOfBooks==null)
        {
            throw new RecordNotFoundException();
        }
        return setOfBooks;
    }

    @Override
    public List<Books> getBooksByName(String keyWord) throws Exception {
        List<Books> setOfBooks=new ArrayList<>();
        setOfBooks=bookRepository.getBookByName(keyWord);
        if(setOfBooks==null || setOfBooks.size()==0)
        {
            throw new TitleNotFoundException();
        }
        return setOfBooks;

    }
}

