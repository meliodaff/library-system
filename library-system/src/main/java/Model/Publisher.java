package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class Publisher extends Author {

    private String address;

    public Publisher(String name, String email, String address) {
        super(name, email);
        this.address = address;
    }
}
