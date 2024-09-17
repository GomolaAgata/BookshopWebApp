package pjatk.tpo.tpo6_ga_s27943;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static final String URL = "jdbc:derby:bazzAst;create=true";
    private  List<Book> books;
    private Connection connection;
    private static final String QUERY = "SELECT TITLE, AUTHORS.NAME AS AUTHOR_NAME, PUBLISHERS.NAME AS PUBLISHER_NAME, PRICE, NUM_PAGES, PUBLICATION_YEAR " +
            "FROM BOOKS " +
            "INNER JOIN AUTHORS ON BOOKS.AUTHOR_ID = AUTHORS.AUTHOR_ID " +
            "INNER JOIN PUBLISHERS ON BOOKS.PUBLISHER_ID = PUBLISHERS.PUBLISHER_ID";

    public DataBase() {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            connection = DriverManager.getConnection(URL);

            executeStatements(createTables);
            executeStatements(insertData);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(QUERY);
            while (resultSet.next()) {
                Book book = new Book(
                        resultSet.getString("TITLE"),
                        resultSet.getString("AUTHOR_NAME"),
                        resultSet.getString("PUBLISHER_NAME"),
                        resultSet.getDouble("PRICE"),
                        resultSet.getInt("NUM_PAGES"),
                        resultSet.getInt("PUBLICATION_YEAR")
                );
                books.add(book);
            }

            for (Book book : books) {
                System.out.println(book);
            }
            System.out.println("done");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    private void executeStatements(String[] statements) throws SQLException {
        for (String statement : statements) {
            connection.createStatement().execute(statement);
        }
    }

    private String[] createTables = {
            "CREATE TABLE AUTHORS (" +
                    "AUTHOR_ID INT PRIMARY KEY, " +
                    "NAME VARCHAR(255) NOT NULL)",

            "CREATE TABLE PUBLISHERS (" +
                    "PUBLISHER_ID INT PRIMARY KEY, " +
                    "NAME VARCHAR(255) NOT NULL)",

            "CREATE TABLE BOOKS (" +
                    "BOOK_ID INT PRIMARY KEY, " +
                    "TITLE VARCHAR(255) NOT NULL, " +
                    "AUTHOR_ID INT NOT NULL, " +
                    "PUBLISHER_ID INT NOT NULL, " +
                    "PRICE DOUBLE NOT NULL, " +
                    "NUM_PAGES INT NOT NULL, " +
                    "PUBLICATION_YEAR INT NOT NULL, " +
                    "FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHORS(AUTHOR_ID), " +
                    "FOREIGN KEY (PUBLISHER_ID) REFERENCES PUBLISHERS(PUBLISHER_ID))"
    };

    private String[] insertData = {
            "INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (1, 'J.K. Rowling')",
            "INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (2, 'George Orwell')",
            "INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (3, 'J.R.R. Tolkien')",
            "INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (4, 'Harper Lee')",
            "INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (5, 'Jane Austen')",
"INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (6, 'Charlotte Brontë')",
"INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (7, 'F. Scott Fitzgerald')",
"INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (9, 'Gabriel García Márquez')" ,
"INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (10, 'Fyodor Dostoevsky')",
"INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (11, 'Leo Tolstoy')",
"INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (12, 'J. D. Salinger')",
"INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (13, 'Ray Bradbury')","INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (20, 'Douglas Adams')",
            "INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (21, 'Khaled Hosseini')",
            "INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (22, 'Chimamanda Ngozi Adichie')",
            "INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (23, 'Margaret Atwood')" ,
            "INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (24, 'Paulo Coelho')" ,
            "INSERT INTO AUTHORS (AUTHOR_ID, NAME) VALUES (27, 'Khaled Hosseini')",
            "INSERT INTO PUBLISHERS (PUBLISHER_ID, NAME) VALUES (1, 'Bloomsbury')",
            "INSERT INTO PUBLISHERS (PUBLISHER_ID, NAME) VALUES (2, 'Secker & Warburg')",
            "INSERT INTO PUBLISHERS (PUBLISHER_ID, NAME) VALUES (3, 'Allen & Unwin')",
            "INSERT INTO PUBLISHERS (PUBLISHER_ID, NAME) VALUES (4, 'J.B. Lippincott & Co.')",
            "INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (1, 'Harry Potter and the Philosophers Stone', 1, 1, 19.99, 223, 1997)",
            "INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (2, '1984', 2, 2, 14.99, 328, 1949)",
            "INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (3, 'The Hobbit', 3, 3, 25.99, 310, 1937)",
            "INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (4, 'To Kill a Mockingbird', 4, 4, 18.99, 281, 1960)",
"INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (5, 'The Lord of the Rings: The Fellowship of the Ring', 3, 3, 29.99, 482, 1954)",
"INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (6, 'The Lord of the Rings: The Two Towers', 3, 3, 29.99, 352, 1955)",
"INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (7, 'The Lord of the Rings: The Return of the King', 3, 3, 29.99, 472, 1955)",
"INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (8, 'Pride and Prejudice', 5, 1, 16.99, 224, 1813)",
"INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (9, 'Jane Eyre', 6, 1, 17.99, 407, 1847)",
"INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (10, 'The Great Gatsby', 7, 2, 12.99, 180, 1925)",
"INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (12, 'One Hundred Years of Solitude', 9, 3, 24.99, 472, 1967)",
"INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (13, 'Crime and Punishment', 10, 2, 18.99, 508, 1866)",
"INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (14, 'War and Peace', 11, 4, 32.99, 1225, 1869)",
"INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (15, 'The Catcher in the Rye', 12, 2, 15.99, 234, 1951)",
"INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (16, 'The Adventures of Huckleberry Finn', 4, 2, 17.99, 224, 1884)",
"INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (17, 'Fahrenheit 451', 13, 2, 14.99,  178, 1953)",
            "INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (21, 'The Kite Runner', 21, 1, 17.99, 336, 2003)",
            "INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (22, 'Half of a Yellow Sun', 22, 4, 16.99, 348, 2006)",
            "INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (24, 'The Alchemist', 24, 3, 14.99, 256, 1988)",
            "INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (29, 'Harry Potter and the Chamber of Secrets', 1, 1, 19.99, 341, 1998)",
            "INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (30, 'Harry Potter and the Prisoner of Azkaban', 1, 1, 19.99, 387, 1999)",
            "INSERT INTO BOOKS (BOOK_ID, TITLE, AUTHOR_ID, PUBLISHER_ID, PRICE, NUM_PAGES, PUBLICATION_YEAR) VALUES (31, 'Harry Potter and the Goblet of Fire', 28, 1, 22.99, 766, 2000)"

    };

    public List<Book> searchBooks(String searchQuery) {
        List<Book> searchedBooks = new ArrayList<>();
        books = getAllBooks();
        for(Book book : books){
            if(book.getTitle().toLowerCase().contains(searchQuery.toLowerCase()) || book.getAuthor().toLowerCase().contains(searchQuery.toLowerCase()) ||
                    book.getPublisher().toLowerCase().contains(searchQuery.toLowerCase())){
                searchedBooks.add(book);
            }
        }
    return searchedBooks;}


    public List<Book> getBooksByPriceRange(double minPrice, double maxPrice) {
        List<Book> filteredBooks = new ArrayList<>();
        books = getAllBooks();
        for (Book book : books) {
            if (book.getPrice() >= minPrice && book.getPrice() <= maxPrice) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

}
