package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAOImplementation implements AuthorDAO {
    Database database = new Database();
    public List<Author> getAuthors(){
        String query = "SELECT * FROM authors";
        List<Author> authors = new ArrayList<>();
        Author author = null;
        try(Connection connection = database.getConnection();
            Statement statement = connection.createStatement();){

            ResultSet result = statement.executeQuery(query);

            while(result.next()){
                author = new Author();
                author.setId(result.getInt("id"));
                author.setName(result.getString("name"));
                author.setEmail(result.getString("email"));
                authors.add(author);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    return authors;
    }

    public Author getSpecificAuthor(int id){
        String query = "SELECT * FROM authors WHERE id = ?";
        Author author = null;

        try(Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if(result.next()){
                author = new Author();

                author.setId(result.getInt("id"));
                author.setName(result.getString("name"));
                author.setEmail(result.getString("email"));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(author == null){
            throw new IllegalArgumentException("No record was found");
        }
        return author;
    }
    public boolean addAuthor(Author author){
        String query = "INSERT INTO authors (name, email) VALUES (?, ?)";

        try(Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);){

            statement.setString(1, author.getName());
            statement.setString(2, author.getEmail());

            int rowsAdded = statement.executeUpdate();

            return rowsAdded > 0;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateAuthor(Author author){
        String query = "UPDATE authors SET name = ?, email = ? WHERE id = ?";
        try(Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);){

            statement.setString(1, author.getName());
            statement.setString(2, author.getEmail());
            statement.setInt(3, author.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAuthor(int id){
        String query = "DELETE FROM authors WHERE id = ?";

        try(Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);){

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


}
