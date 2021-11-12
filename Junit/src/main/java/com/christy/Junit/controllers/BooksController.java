package com.christy.Junit.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.christy.Junit.domain.Books;
import com.christy.Junit.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    @Autowired
    public BookService bookService;
    @GetMapping("/getbyBookId/{bookId}")
    public ResponseEntity<Books> getBookId(@PathVariable String bookId)
    {

        try {

            Books gotBooks= bookService.getBookByBookId(bookId);
            System.out.println(gotBooks);
            return new ResponseEntity<>(gotBooks, HttpStatus.OK);
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }



    }

    @GetMapping("/search/{bookName}")
    public ResponseEntity<List<Books>> getBookName(@PathVariable String bookName)
    {

        try {

            List<Books> gotBooks= bookService.getBooksByName(bookName);
            System.out.println(gotBooks);
            return new ResponseEntity<>(gotBooks,HttpStatus.OK);
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);

        }




    }
    @GetMapping("")
    public ResponseEntity<List<Books>> getAllBooks()
    {
        try {
            List<Books> returnedBooks = bookService.getAllBooks();

            return new ResponseEntity<>(returnedBooks, HttpStatus.OK);
        }

        catch(Exception e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
    @PostMapping("/postbooks")
    public ResponseEntity<String> myposter()
    {

        try {

            ObjectMapper objectMapper=new ObjectMapper();
            File from = new File("book_details.json");
            TypeReference<Books[]> typeRef
                    = new TypeReference<Books[]>() {};

            Books[] o = objectMapper.readValue(from, typeRef);
            for(Books eachBook:o)
            {
                try {
                    bookService.addBook(eachBook);
                }
                catch(Exception e)
                {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, e.getMessage(), e);
                }
            }
            return new ResponseEntity<>("All records inserted succcessfully inserted into db!!", HttpStatus.OK);

        }
        catch(IOException e)
        {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }





    }


}
