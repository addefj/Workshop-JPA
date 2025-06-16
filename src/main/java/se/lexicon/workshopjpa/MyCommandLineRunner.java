package se.lexicon.workshopjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.workshopjpa.entity.AppUser;
import se.lexicon.workshopjpa.entity.Book;
import se.lexicon.workshopjpa.entity.BookLoan;
import se.lexicon.workshopjpa.entity.Details;
import se.lexicon.workshopjpa.repository.AppUserRepository;
import se.lexicon.workshopjpa.repository.BookLoanRepository;
import se.lexicon.workshopjpa.repository.BookRepository;
import se.lexicon.workshopjpa.repository.DetailsRepository;

import java.time.LocalDate;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    private DetailsRepository detailsRepository;
    private AppUserRepository appUserRepository;
    private BookLoanRepository bookLoanRepository;
    private BookRepository bookRepository;

    @Autowired
    public MyCommandLineRunner(DetailsRepository detailsRepository, AppUserRepository appUserRepository, BookLoanRepository bookLoanRepository, BookRepository bookRepository) {
        this.detailsRepository = detailsRepository;
        this.appUserRepository = appUserRepository;
        this.bookLoanRepository = bookLoanRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("##### App has started #####");

        //testing methods in AppUser and Details repositories
//        Details details = new Details("adde.fj@gmail.com", "Andreas", LocalDate.now());
//        detailsRepository.save(details);
//        AppUser appUser = new AppUser("admin", "password", details);
//        appUserRepository.save(appUser);
//        System.out.println("find by Username" + appUserRepository.findByUsername("admin"));
//        System.out.println("-----------------");
//        System.out.println("find by regdate" + appUserRepository.findByRegDateIsBetween(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 31)));
//        System.out.println("-----------------");
//        System.out.println("find by userdetails email" + appUserRepository.findByUserDetailsEmail("adde.fj@gmail.com"));
//        System.out.println("-----------------");
//        System.out.println("find by userdetails id" + appUserRepository.findByUserDetailsId(1));
//        System.out.println("-----------------");
//        System.out.println("find by name contains" + detailsRepository.findByNameContains("And"));
//        System.out.println("-----------------");
//        System.out.println("find by email" + detailsRepository.findByEmail("adde.fj@gmail.com"));
//        System.out.println("-----------------");
//        System.out.println("find by name ignore case" + detailsRepository.findByNameIgnoreCase("andreas"));


        //testing methods in BookLoan and Book repositories
        Details details = new Details("adde.fj@gmail.com", "Andreas", LocalDate.now());
        detailsRepository.save(details);
        AppUser appUser = new AppUser("admin", "password", details);
        appUserRepository.save(appUser);
        Book book = new Book("1234567890", "The Hobbit", 10);
        bookRepository.save(book);
        BookLoan bookLoan = new BookLoan(appUser, book);
        bookLoanRepository.save(bookLoan);

        System.out.println(bookRepository.findByIsbnIgnoreCase("1234567890"));
    }
}
