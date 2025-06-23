package se.lexicon.workshopjpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.workshopjpa.entity.Details;

import java.util.List;

@Repository
public interface DetailsRepository extends CrudRepository<Details, Integer> { //extends CrudRepository to get the implemented Crud methods

    //extra methods defined
    Details findByEmail(String email);
    List<Details> findByNameContains(String name);
    List<Details> findByNameIgnoreCase(String name);

}