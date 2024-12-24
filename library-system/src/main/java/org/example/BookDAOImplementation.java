package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImplementation implements BookDAO{
    public static final String URL = "jdbc:mysql://localhost:3306/library_db";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";


    public Connection getConnection() throws Exception{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        String query = "CALL getBooks()";
        Book book = null;
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();){

            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                book = new Book();

                book.setId(result.getInt("id"));
                book.setTitle(result.getString("title"));
                book.setGenre(result.getString("genre"));
                book.setYear(result.getString("year"));
                book.setStock(result.getInt("stock"));
                book.setAuthor(result.getString("author_name"));
                book.setPublisher(result.getString("publisher_name"));

                books.add(book);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return books;
    }
    public Book getSpecificBook(int id){
        String query = "CALL getSpecificBook(?)";
        Book book = null;
        try(Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall(query);){
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            if(result.next()){
                book = new Book();
                book.setTitle(result.getString("title"));
                book.setGenre(result.getString("genre"));
                book.setYear(result.getString("year"));
                book.setStock(result.getInt("stock"));
                book.setAuthor(result.getString("author_name"));
                book.setPublisher(result.getString("publisher_name"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(book == null){
            throw new IllegalArgumentException("No record was found");
        }
        return book;
    }
    public Book getSpecificBook(String word){

        if(true){
            throw new IllegalArgumentException("No strings please");
        }

        return null;
    } // to prevent the user from typing String instead of int. can be better

}
