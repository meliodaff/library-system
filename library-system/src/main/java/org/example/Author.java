package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class Author {
    private int id;
    private String name;
    private String email;

    public Author(String name, String email){
        this.name = name;
        this.email = email;
    }
}
