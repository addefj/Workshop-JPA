package se.lexicon.workshopjpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode
@ToString(exclude = "password")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class AppUser {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100, unique = true)
    private String username;
    @Column(nullable = false, length = 100)
    private String password;
    private LocalDate regDate;

    @OneToOne()
    @JoinColumn(name = "details_id")
    private Details userDetails;

    //constructor
    public AppUser(String username, String password, Details userDetails) {
        this.username = username;
        this.password = password;
        this.userDetails = userDetails;
    }

    @PrePersist
    public void prePersist(){
        this.regDate = LocalDate.now();
    }
}


