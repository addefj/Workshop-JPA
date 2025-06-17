package se.lexicon.workshopjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.workshopjpa.entity.*;
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

        Details details = new Details("test.test@test.com", "Andreas", LocalDate.now());
        AppUser appUser = new AppUser("admin", "password", details);
        AppUser createdUser = appUserRepository.save(appUser);
        Book book = new Book("1234567890", "The Hobbit", 10);
        Book createdBook = bookRepository.save(book);
        BookLoan bookLoan = new BookLoan(createdUser, createdBook);
        BookLoan createdBookLoan = bookLoanRepository.save(bookLoan);

    }
}
