package mk.ukim.finki.av2_emt.service.impl;

import mk.ukim.finki.av2_emt.model.Author;
import mk.ukim.finki.av2_emt.model.Book;
import mk.ukim.finki.av2_emt.model.dto.BookDto;
import mk.ukim.finki.av2_emt.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.av2_emt.model.exceptions.BookNotFoundException;
import mk.ukim.finki.av2_emt.repository.AuthorJpaRepository;
import mk.ukim.finki.av2_emt.repository.BookJpaRepository;
import mk.ukim.finki.av2_emt.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookJpaRepository bookJpaRepository;
    private final AuthorJpaRepository authorJpaRepository;

    public BookServiceImpl(BookJpaRepository bookJpaRepository, AuthorJpaRepository authorJpaRepository) {
        this.bookJpaRepository = bookJpaRepository;
        this.authorJpaRepository = authorJpaRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookJpaRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookJpaRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author=this.authorJpaRepository.findById(bookDto.getAuthor())
                .orElseThrow(()->new AuthorNotFoundException(bookDto.getAuthor()));

        this.bookJpaRepository.deleteByName(bookDto.getName());
        Book book=new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        this.bookJpaRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book=this.bookJpaRepository.findById(id)
                .orElseThrow(()->new BookNotFoundException(id));

        Author author=this.authorJpaRepository.findById(bookDto.getAuthor())
                .orElseThrow(()->new AuthorNotFoundException(bookDto.getAuthor()));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        this.bookJpaRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        bookJpaRepository.deleteById(id);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorJpaRepository.findAll();
    }

    @Override
    public Book like(Long id) {
        Book b=bookJpaRepository.findById(id).orElse(null);

        int likes=b.getAvailableCopies();
        likes--;
        b.setAvailableCopies(likes);
        return bookJpaRepository.save(b);
    }
}
