package pro.bolshakov.geekbrains.lesson4.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "author_sale")
public class AuthorSell {
    @EmbeddedId
    private AuthorDateKey key;
    private Double sum;

    public AuthorSell() {
    }

    public AuthorDateKey getKey() {
        return key;
    }

    public void setKey(AuthorDateKey key) {
        this.key = key;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
