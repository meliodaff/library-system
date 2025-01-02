package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class ReturnBook {
    private int adminId;
    private int transactionId;
    private String condition;
    private int bookId;

    public ReturnBook(int adminId, int transactionId, String condition) {
        this.adminId = adminId;
        this.transactionId = transactionId;
        this.condition = condition;
    }

}
