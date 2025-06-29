package se.lexicon.workshopjpa.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.workshopjpa.entity.AppUser;
import se.lexicon.workshopjpa.entity.Details;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DetailsRepositoryTest {

    @Autowired
    private DetailsRepository detailsRepository;

    @Test
   // @Order(1)
    @DisplayName("Test Save Method")
    void testSaveDetails() {

        //scenario
        Details details = new Details("test.test@test.com", "Test", LocalDate.of(1990, 1, 1));

        //test method
        Details saved = detailsRepository.save(details);

        //verify
        assertThat(saved.getId()).isNotNull();
    }

    @Test
    @DisplayName("Test FindByEmail")
    void testFindByEmail(){

        //scenario
        Details details = new Details("test.test@test.com", "Test", LocalDate.of(1990, 1, 1));
        detailsRepository.save(details);

        //test method
        Details result = detailsRepository.findByEmail("test.test@test.com");

        //verify
        assertNotNull(result);
        assertEquals(details, result);
    }

    @Test
    @DisplayName("Test FindByNameContains")
    void testFindByNameContains(){

        //scenario
        Details details1 = new Details("test1.test@test.com", "Test1", LocalDate.of(1990, 1, 1));
        detailsRepository.save(details1);
        Details details2 = new Details("test2.test@test.com", "Test2", LocalDate.of(1990, 1, 1));
        detailsRepository.save(details2);

        //test method
        List<Details> result = detailsRepository.findByNameContains("es");

        //verify
        assertNotNull(result);
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Test FindByNameIgnoreCase")
    void testFindByNameIgnoreCase(){

        //scenario
        Details details1 = new Details("test1.test@test.com", "Test1", LocalDate.of(1990, 1, 1));
        detailsRepository.save(details1);
        Details details2 = new Details("test2.test@test.com", "Test2", LocalDate.of(1990, 1, 1));
        detailsRepository.save(details2);

        //test method
        List<Details> result = detailsRepository.findByNameIgnoreCase("test1");

        //verify
        assertNotNull(result);
        assertThat(result.size()).isEqualTo(1);
    }

    //extra test generated by AI
    @Test
    @DisplayName("Test Find All Details")
    void testFindAll() {
        // scenario
        Details details1 = new Details("test1@test.com", "User1", LocalDate.of(1990, 1, 1));
        Details details2 = new Details("test2@test.com", "User2", LocalDate.of(1995, 2, 2));
        detailsRepository.save(details1);
        detailsRepository.save(details2);

        // test method - convert Iterable to List
        List<Details> result = StreamSupport
                .stream(detailsRepository.findAll().spliterator(), false)
                .toList();

        // verify
        assertThat(result.size()).isEqualTo(2);
        assertTrue(result.contains(details1));
        assertTrue(result.contains(details2));
    }

    @Test
    @DisplayName("Test Delete Details By ID")
    void testDeleteById() {
        // scenario
        Details details = new Details("delete@test.com", "DeleteMe", LocalDate.of(1980, 5, 5));
        Details saved = detailsRepository.save(details);

        Integer savedId = saved.getId();

        // pre-condition check
        assertNotNull(detailsRepository.findById(savedId).orElse(null));

        // test method
        detailsRepository.deleteById(savedId);

        // verify
        assertFalse(detailsRepository.findById(savedId).isPresent());
    }

}

