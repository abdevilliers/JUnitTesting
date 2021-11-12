create database sample_db;
select current_database();
/c sample_db;
create table book_dtls(bookid text primary key ,title text,authors text,average_rating text,isbn text,language_code text, ratings_count text,price text);
