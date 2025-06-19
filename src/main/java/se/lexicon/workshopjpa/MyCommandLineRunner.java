package se.lexicon.workshopjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.workshopjpa.entity.*;
import se.lexicon.workshopjpa.repository.*;

import java.time.LocalDate;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    private DetailsRepository detailsRepository;
    private AppUserRepository appUserRepository;
    private BookLoanRepository bookLoanRepository;
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public MyCommandLineRunner(DetailsRepository detailsRepository, AppUserRepository appUserRepository,
                               BookLoanRepository bookLoanRepository, BookRepository bookRepository,
                               AuthorRepository authorRepository) {
        this.detailsRepository = detailsRepository;
        this.appUserRepository = appUserRepository;
        this.bookLoanRepository = bookLoanRepository;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("##### App has started #####");

        Details details = new Details("test.test@test.com", "Andreas", LocalDate.now());
        Details savedDetails = detailsRepository.save(details);
        AppUser appUser = new AppUser("admin", "password", savedDetails);
        AppUser createdUser = appUserRepository.save(appUser);
        Author author = new Author("Author", "Authorsson");
        Author createdAuthor = authorRepository.save(author);
        Book book = new Book("1234567890", "The Hobbit", 10);
        Book createdBook = bookRepository.save(book);

        createdBook.getAuthors().add(createdAuthor);
        bookRepository.save(createdBook);
        createdAuthor.getWrittenBooks().add(createdBook);

        BookLoan bookLoan = new BookLoan(createdBook);
        createdUser.addBookLoan(bookLoan);
        bookLoanRepository.save(bookLoan);
        appUserRepository.save(createdUser);

        //System.out.println(createdUser);
        //System.out.println(createdUser.getBookLoans());
        //System.out.println("--------------");
        System.out.println(bookLoan);

    }
}
