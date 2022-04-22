DROP DATABASE IF EXISTS cloudNative;
CREATE DATABASE cloudNative;
USE cloudNative;
drop table if exists book CASCADE;
create table book (id integer auto_increment, title varchar(255) not null, author varchar(255) not null, genre varchar(255), publication_year integer not null, primary key(id)); 

INSERT INTO book (title, author, genre, publication_year) VALUES ('The Way of Kings', 'Brandon Sanderson', 'Fantasy', 2010);
INSERT INTO book (title, author, genre, publication_year) VALUES ('The Snowman', 'Jo Nesbo', 'Crime Thriller', 2010);
INSERT INTO book (title, author, genre, publication_year) VALUES ('Knife', 'Jo Nesbo', 'Crime Thriller', 2019);
INSERT INTO book (title, author, genre, publication_year) VALUES ('The Outsider', 'Albert Camus', 'Crime Thriller', 1942);
INSERT INTO book (title, author, genre, publication_year) VALUES ('Fire', 'Kristin Cashore', 'Fantasy', 2009);
INSERT INTO book (title, author, genre, publication_year) VALUES ('Freedom\'s Challenge', 'Anne McCaffrey', 'Fantasy', 1998);
INSERT INTO book (title, author, genre, publication_year) VALUES ('Nimisha\'s Ship', 'Anne McCaffrey', 'Fantasy', 1998);
INSERT INTO book (title, author, genre, publication_year) VALUES ('Phanton', 'Jo Nesbo', 'Crime Thriller', 2011);
INSERT INTO book (title, author, genre, publication_year) VALUES ('On This Day She', 'Jo Bell', 'Historical', 2021);
INSERT INTO book (title, author, genre, publication_year) VALUES ('The Goldfinch', 'Donna Tartt', 'Crime Thriller', 2014);
SELECT * FROM book;