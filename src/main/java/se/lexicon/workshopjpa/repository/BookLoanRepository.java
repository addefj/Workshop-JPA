package se.lexicon.workshopjpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.workshopjpa.entity.BookLoan;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {
    List<BookLoan> findByBorrowerId(int id);
    BookLoan findByBookId(int id);
    List<BookLoan> findByReturnedIsFalse();
    List<BookLoan> findByDueDateBefore(LocalDate today);
    List<BookLoan> findByLoanDateIsBetween(LocalDate startDate, LocalDate endDate);
    void setReturnedTrueByBookLoanId(int id);
}
