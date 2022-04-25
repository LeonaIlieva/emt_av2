package mk.ukim.finki.av2_emt.service;

import mk.ukim.finki.av2_emt.model.Author;
import mk.ukim.finki.av2_emt.model.Book;
import mk.ukim.finki.av2_emt.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    List<Author> findAllAuthors();

    Book like(Long id);
}
