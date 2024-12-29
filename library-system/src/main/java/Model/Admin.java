package Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Admin {
    private int id;
    private String name;
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
