package se.lexicon.workshopjpa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshopjpa.entity.BookLoan;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {
    List<BookLoan> findByBorrowerId(int id);
    BookLoan findByBookId(int id);
    List<BookLoan> findByReturnedIsFalse();
    List<BookLoan> findByReturnedIsFalseAndDueDateBefore(LocalDate date);

    List<BookLoan> findByLoanDateIsBetween(LocalDate startDate, LocalDate endDate);

    @Transactional
    @Modifying
    @Query("UPDATE BookLoan bl SET bl.returned = true WHERE bl.id = :id")
    void setReturnedTrueByBookLoanId(@Param("id") int id);

}
