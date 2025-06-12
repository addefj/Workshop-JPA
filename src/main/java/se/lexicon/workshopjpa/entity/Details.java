package se.lexicon.workshopjpa.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@EqualsAndHashCode //generates equals and hashcode methods automatically
@ToString //generates a toString method
@NoArgsConstructor //generates a no-args constructor
@AllArgsConstructor //generates a constructor with all fields
@Getter //generates getters for all fields
@Setter //generates setters for all fields
@Entity //makes this class an entity in the IoC container
public class Details {

    //fields
    @Id //makes id the primary key in Database
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generates an id with autoincrement for each entity
    @Setter(AccessLevel.NONE)
    private int id;
    @Column(nullable = false, length = 100, unique = true) //limits email to 100 chars, and makes sure its unique and not null
    private String email;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    @Setter(AccessLevel.NONE)
    private LocalDate birthDate;

    //constructor
    public Details(String email, String name, LocalDate birthDate) {
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }
}
