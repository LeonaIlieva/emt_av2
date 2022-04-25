package mk.ukim.finki.av2_emt.repository;

import mk.ukim.finki.av2_emt.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Long> {

    void deleteByName(String name);

    @Modifying
    @Query("update Book b set b.availableCopies=?2 where b.id=?1")
    void change(Long id, int value);
}
