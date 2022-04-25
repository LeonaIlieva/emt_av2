package mk.ukim.finki.av2_emt.web;

import mk.ukim.finki.av2_emt.model.Author;
import mk.ukim.finki.av2_emt.service.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final BookService bookService;

    public AuthorRestController(BookService bookService){
        this.bookService=bookService;
    }

    @GetMapping
    private List<Author> findAll(){
        List<Author> authorList=this.bookService.findAllAuthors();

        return authorList;
    }
}
