package org.example;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Author {
    private int id;
    private String name;
    private String email;

    private List<Book> books; // comprehend this more bialen xD

    // constructor for adding author record
    public Author(String name, String email){
        this.name = name;
        this.email = email;
    }

}
