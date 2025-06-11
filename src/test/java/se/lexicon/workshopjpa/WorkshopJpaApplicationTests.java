package se.lexicon.workshopjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.workshopjpa.entity.AppUser;
import se.lexicon.workshopjpa.entity.Details;
import se.lexicon.workshopjpa.repository.AppUserRepository;
import se.lexicon.workshopjpa.repository.DetailsRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class WorkshopJpaApplicationTests {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private DetailsRepository detailsRepository;

    @Test
    void testFindByUsername(){
        Details details = new Details("test.test@test.com", "Test", LocalDate.of(1990, 1, 1));
        detailsRepository.save(details);
        AppUser appUser = new AppUser("admin", "password", details);
        appUserRepository.save(appUser);


        assertEquals(appUser, appUserRepository.findByUsername("admin"));

    }

    @Test
    void testFindByUserDetailsEmail() {
        Details details = new Details("findme@test.com", "Finder", LocalDate.of(1975, 3, 10));
        detailsRepository.save(details);

        AppUser user = new AppUser("finderUser", "1234", details);
        appUserRepository.save(user);

        AppUser found = appUserRepository.findByUserDetailsEmail("findme@test.com");

        assertNotNull(found);
        assertEquals("finderUser", found.getUsername());
    }

    @Test
    void testFindByUserDetailsId() {
        Details details = new Details("unique@test.com", "Unique", LocalDate.of(1980, 5, 15));
        detailsRepository.save(details);

        AppUser user = new AppUser("uniqueUser", "secret", details);
        appUserRepository.save(user);

        AppUser found = appUserRepository.findByUserDetailsId(details.getId());

        assertNotNull(found);
        assertEquals("uniqueUser", found.getUsername());
    }

}