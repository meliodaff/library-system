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

    // constructor for adding author record
    public Author(String name, String email){
        this.name = name;
        this.email = email;
    }
}
