package com.christy.Junit;

import com.christy.Junit.Services.BookServiceImpl;
import com.christy.Junit.domain.Books;
import com.christy.Junit.exceptions.RecordNotFoundException;
import com.christy.Junit.exceptions.TitleNotFoundException;
import com.christy.Junit.repositories.BookRepository;
import com.christy.Junit.repositories.BookRepositoryImp;
import org.checkerframework.checker.fenum.qual.AwtAlphaCompositingRule;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
class JunitApplicationTests {



	@Mock
	BookRepository bookRepository;

	@InjectMocks
	BookServiceImpl bookService=new BookServiceImpl();



	@Test
	void contextLoads() {
		when(bookRepository.getBookByBookId("1")).thenReturn(null);
		assertThrows(RecordNotFoundException.class, () -> {
			bookService.getBookByBookId("1");
		});
	}

	@Test
	void getAllBooksServiceTest() throws Exception
	{

		when(bookRepository.getAllBooks()).thenReturn(null);
		assertThrows(RecordNotFoundException.class, () -> {
			bookService.getAllBooks();
		});
	}

	@Test
	void getAllBooksServiceTestOne() throws Exception
	{
      List<Books> listOfBooks=new ArrayList<>();
	  //listOfBooks.add(new Books());
		when(bookRepository.getAllBooks()).thenReturn(listOfBooks);
		assertThrows(RecordNotFoundException.class, () -> {
			bookService.getAllBooks();
		});
	}

	@Test
	void getAllBooksServiceTestTwo() throws Exception
	{
		List<Books> listOfBooks=new ArrayList<>();
		listOfBooks.add(new Books());
		when(bookRepository.getAllBooks()).thenReturn(listOfBooks);
		List<Books> returnedBooks=bookService.getAllBooks();
		assertThat(listOfBooks).isSameAs(returnedBooks);

	}

	@Test
	void getBookByBookIdTestOne() throws Exception
	{
		List<Books> listOfBooks=new ArrayList<>();
		//listOfBooks.add(new Books());
		when(bookRepository.getBookByBookId("1")).thenReturn(null);
		assertThrows(RecordNotFoundException.class, () -> {
			bookService.getBookByBookId("1");
		});
	}

	@Test
	void getBookByBookIdTestTwo() throws Exception
	{
		Books b=new Books();
		//listOfBooks.add(new Books());
		when(bookRepository.getBookByBookId("1")).thenReturn(b);
		Books returnedBook=bookService.getBookByBookId("1");
		assertThat(b).isSameAs(returnedBook);


	}

	@Test
	void getBookByBookNameTestOne() throws Exception
	{
		List<Books> listOfBooks=new ArrayList<>();
		//listOfBooks.add(new Books());
		when(bookRepository.getBookByName("1")).thenReturn(null);
		assertThrows(TitleNotFoundException.class, () -> {
			bookService.getBooksByName("1");
		});
	}

	@Test
	void getBookByBookNameTestTwo() throws Exception
	{
		List<Books> listOfBooks=new ArrayList<>();
		//listOfBooks.add(new Books());
		when(bookRepository.getBookByName("1")).thenReturn(listOfBooks);
		assertThrows(TitleNotFoundException.class, () -> {
			bookService.getBooksByName("1");
		});
	}

	@Test
	void getBooksByNameTestThree() throws Exception
	{
		List<Books> b=new ArrayList<>();
		b.add(new Books());
		when(bookRepository.getBookByName("1")).thenReturn(b);
		List<Books> returnedBook=bookService.getBooksByName("1");
		assertThat(b).isSameAs(returnedBook);


	}











}
