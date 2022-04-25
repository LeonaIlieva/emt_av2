package mk.ukim.finki.av2_emt.web;

import mk.ukim.finki.av2_emt.model.CategoryType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryRestController {

    @GetMapping
    private List<CategoryType> findAll(){
        List<CategoryType> categoryTypes=new ArrayList<>();
        categoryTypes.add(CategoryType.DRAMA);
        categoryTypes.add(CategoryType.NOVEL);
        categoryTypes.add(CategoryType.CLASSICS);
        categoryTypes.add(CategoryType.BIOGRAPHY);
        categoryTypes.add(CategoryType.FANTASY);
        categoryTypes.add(CategoryType.HISTORY);
        categoryTypes.add(CategoryType.THRILLER);

        return categoryTypes;
    }
}
