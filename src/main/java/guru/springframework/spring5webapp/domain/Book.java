package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
    private String isbn;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Book() {
    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher=" + publisher +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return Objects.equals(Id, book.Id);
    }

    @Override
    public int hashCode() {
        return Id != null ? Id.hashCode() : 0;
    }
}
