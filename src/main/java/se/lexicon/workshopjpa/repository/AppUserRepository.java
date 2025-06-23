package se.lexicon.workshopjpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.workshopjpa.entity.AppUser;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> { //extends CrudRepository to get the implemented Crud methods

    //extra methods defined
    AppUser findByUsername(String username);

    List<AppUser> findByRegDateIsBetween(LocalDate startDate, LocalDate endDate);

    AppUser findByUserDetailsId(int id);

    AppUser findByUserDetailsEmail(String email);

}
