package org.example;

import java.sql.Connection;
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
/*
    public Author getSpecificAuthor(int id){

    }

    public boolean addAuthoer(Author author){

    }
    public boolean updateAuthor(Author author){

    }
    public boolean deleteAuthor(int id){

    }

 */
}
