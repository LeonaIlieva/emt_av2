package mk.ukim.finki.av2_emt.model.dto;

import lombok.Data;
import mk.ukim.finki.av2_emt.model.CategoryType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class BookDto {
    String name;

    @Enumerated(value=EnumType.STRING)
    CategoryType category;

    Long author;

    int availableCopies;

    public BookDto() {
    }

    public BookDto(String name, CategoryType category, Long author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
