package mk.ukim.finki.av2_emt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Enumerated(value = EnumType.STRING)
    CategoryType category;

    @ManyToOne
    Author author;

    int availableCopies;

    public Book() {
    }

    public Book(String name, CategoryType category, Author author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
