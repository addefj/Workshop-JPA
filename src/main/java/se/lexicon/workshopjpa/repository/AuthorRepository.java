package se.lexicon.workshopjpa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.workshopjpa.entity.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

    Author findByFirstNameIgnoreCase(String firstName);
    Author findByLastNameIgnoreCase(String lastName);
    Author findByFirstNameAndLastNameContainingIgnoreCase(String firstName, String lastName);

    @Query("SELECT a FROM Author a JOIN a.writtenBooks b WHERE b.id = :id")
    List<Author> findAuthorsByBookId(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("UPDATE Author au SET au.firstName = :firstName, au.lastName = :lastName WHERE au.id = :id")
    void updateName(@Param("id") int id,
                    @Param("firstName") String firstName,
                    @Param("lastName") String lastName);

    void deleteById(int id);
}
