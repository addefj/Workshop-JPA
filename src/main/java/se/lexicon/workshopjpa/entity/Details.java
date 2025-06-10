package se.lexicon.workshopjpa.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Details {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false, length = 100)
    private String name;
    private LocalDate birthDate;
}
