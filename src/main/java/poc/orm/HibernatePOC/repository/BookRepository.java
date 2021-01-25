package poc.orm.HibernatePOC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poc.orm.HibernatePOC.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
