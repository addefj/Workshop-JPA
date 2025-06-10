package se.lexicon.workshopjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Entity
public class AppUser {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Setter private String username;
    @Setter private String password;
    private LocalDate regDate;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private Details userDetails;

    //constructors
    public AppUser() {
    }

    public AppUser(int id, String username, String password, LocalDate regDate, Details userDetails) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.regDate = regDate;
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", regDate=" + regDate +
                ", userDetails=" + userDetails +
                '}';
    }
}


