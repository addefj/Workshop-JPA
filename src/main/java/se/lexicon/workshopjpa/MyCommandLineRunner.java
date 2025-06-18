package se.lexicon.workshopjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.workshopjpa.entity.*;
import se.lexicon.workshopjpa.repository.*;

import java.time.LocalDate;
import java.util.HashSet;

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
        Book book2 = new Book("1234567891", "The Hobbit 2", 10);
        Book book3 = new Book("1234567892", "The Hobbit 3", 10);
        Book createdBook = bookRepository.save(book);
        Book createdBook2 = bookRepository.save(book2);
        Book createdBook3 = bookRepository.save(book3);

        createdBook.getAuthors().add(createdAuthor);
        createdBook2.getAuthors().add(createdAuthor);
        createdBook3.getAuthors().add(createdAuthor);
        createdAuthor.getWrittenBooks().add(createdBook);
        createdAuthor.getWrittenBooks().add(createdBook2);
        createdAuthor.getWrittenBooks().add(createdBook3);
        //System.out.println(createdBook.getAuthors());
        System.out.println(createdAuthor.getWrittenBooks());

        //System.out.println(authorRepository.findAuthorsByBookId(createdBook.getId()));

        //authorRepository.delete(createdAuthor);
        //authorRepository.updateName(createdAuthor.getId(), "Author2", "Authorsson2");
        //System.out.println(authorRepository.findByFirstNameIgnoreCase("author"));
        //System.out.println(authorRepository.findByLastNameIgnoreCase("authorsson"));
        //System.out.println(authorRepository.findByFirstNameAndLastNameContainingIgnoreCase("author", "son"));



    }
}
