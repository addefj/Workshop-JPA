package se.lexicon.workshopjpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@ToString
@NoArgsConstructor //generates a no-args constructor
@AllArgsConstructor //generates a constructor with all fields
@Setter //generates setters for all fields
@Getter //generates getters for all fields
@Entity //makes this class an entity in the IoC container
public class AppUser {

    //fields
    @Id //makes id the primary key in Database
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generates an id with autoincrement for each entity
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(nullable = false, length = 100, unique = true) //limits username to 100 chars, and makes sure its unique and not null
    private String username;

    @Column(nullable = false, length = 100)
    @ToString.Exclude
    private String password;

    @Setter(AccessLevel.NONE)
    private LocalDate regDate;

    @OneToOne //makes sure only one userDetails can be linked to one AppUser
    @JoinColumn(name = "details_id", unique = true) //column name for the joined column
    private Details userDetails;

    @ToString.Exclude
    @OneToMany(mappedBy = "borrower")
    private List<BookLoan> bookLoans = new ArrayList<>();

    //constructor
    public AppUser(String username, String password, Details userDetails) {
        this.username = username;
        this.password = password;
        this.userDetails = userDetails;
    }

    @PrePersist
    public void prePersist(){ //saves the registration date when the entity is saved to the database
        if (this.regDate == null) {
            this.regDate = LocalDate.now();
        }
    }

    //helper methods
    public void addBookLoan(BookLoan bookLoan){
        bookLoans.add(bookLoan);
        bookLoan.setBorrower(this);
    }
}


