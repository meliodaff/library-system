package org.example;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Author {
    private int id;
    private String name;
    private String email;

    private String title;
    private String genre;
    private int stock;
    private String year;

    // constructor for adding author record
    public Author(String name, String email){
        this.name = name;
        this.email = email;
    }
}
