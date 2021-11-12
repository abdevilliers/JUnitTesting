package com.christy.Junit.repositories;

import com.christy.Junit.domain.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class BookRepositoryImp implements BookRepository{
    private static final String INSERT_SQL="INSERT INTO book_dtls (bookid,title,authors,average_rating,isbn,language_code,ratings_count,price) values(:bookid,:title,:authors,:average_rating,:isbn,:language_code,:ratings_count,:price)";
    private static final String SELECT_SQL="SELECT * FROM book_dtls";
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    public JdbcTemplate jdbcTemplate;
    @Override
    public String addBook(Books book) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("bookid", book.getBookID())
                .addValue("title", book.getTitle())
                .addValue("authors", book.getAuthors())
                .addValue("average_rating", book.getAverage_rating())
                .addValue("isbn", book.getIsbn())
                .addValue("language_code",book.getLanguage_code())
                .addValue("ratings_count", book.getRatings_count())
                .addValue("price", book.getPrice());

        namedParameterJdbcTemplate.update(INSERT_SQL, parameters, keyHolder);

        return book.getBookID();

    }

    @Override
    public List<Books> getAllBooks() throws Exception {

        List<Books> setBooks = jdbcTemplate.query(SELECT_SQL, ( ResultSet rs, int rowNum) -> new Books(rs.getString("bookid"),
                rs.getString("title"),
                rs.getString("authors"),
                rs.getString("average_rating"),
                rs.getString("isbn"),
                rs.getString("language_code"),
                rs.getString("ratings_count"),
                rs.getString("price")

        ));
        return setBooks;


    }

    @Override
    public Books getBookByBookId(String BookId) {

        List<Books> setBooks = jdbcTemplate.query(SELECT_SQL, ( ResultSet rs, int rowNum) -> new Books(rs.getString("bookid"),
                rs.getString("title"),
                rs.getString("authors"),
                rs.getString("average_rating"),
                rs.getString("isbn"),
                rs.getString("language_code"),
                rs.getString("ratings_count"),
                rs.getString("price")

        ));
        for(Books book:setBooks)
        {
            if(book.getBookID().equals(BookId))
            {
                return book;
            }
        }
        return null;


    }

    @Override
    public List<Books> getBookByName(String keyWord) {
        List<Books> setBooks = jdbcTemplate.query(SELECT_SQL, ( ResultSet rs, int rowNum) -> new Books(rs.getString("bookid"),
                rs.getString("title"),
                rs.getString("authors"),
                rs.getString("average_rating"),
                rs.getString("isbn"),
                rs.getString("language_code"),
                rs.getString("ratings_count"),
                rs.getString("price")

        ));
        List<Books> retans=new ArrayList<>();
        keyWord=keyWord.toLowerCase();
        for(Books eachBook:setBooks)
        {
            String curtitle=eachBook.getTitle();
            curtitle=curtitle.toLowerCase();
            if(curtitle.contains(keyWord))
            {
                retans.add(eachBook);
            }
        }
        return retans;
    }
}

