package se.lexicon.workshopjpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.workshopjpa.entity.AppUser;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
}
