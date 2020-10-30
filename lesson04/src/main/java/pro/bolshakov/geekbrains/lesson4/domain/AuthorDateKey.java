package pro.bolshakov.geekbrains.lesson4.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class AuthorDateKey implements Serializable {
    @Column(name = "date")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public AuthorDateKey() {
    }

    public AuthorDateKey(LocalDate date, Author author) {
        this.date = date;
        this.author = author;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDateKey authorDateKey = (AuthorDateKey) o;
        return Objects.equals(date, authorDateKey.date) &&
                Objects.equals(author, authorDateKey.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, author);
    }
}
