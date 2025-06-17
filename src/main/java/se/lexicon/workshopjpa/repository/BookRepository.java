package se.lexicon.workshopjpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.workshopjpa.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
//    Book findByIsbnIgnoreCase(String isbn);
//    Book findByTitleContainsIgnoreCase(String title);
//    List<Book> findByMaxLoanDaysLessThan(int maxLoanDays);
}
