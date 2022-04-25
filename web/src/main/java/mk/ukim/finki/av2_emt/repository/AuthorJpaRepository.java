package mk.ukim.finki.av2_emt.repository;

import mk.ukim.finki.av2_emt.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorJpaRepository extends JpaRepository<Author, Long> {
}
