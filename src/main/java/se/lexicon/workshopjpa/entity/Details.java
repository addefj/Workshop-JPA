package se.lexicon.workshopjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Entity
public class Details {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Setter private String email;
    @Setter private String name;
    private LocalDate birthDate;

    //constructors
    public Details() {
    }

    public Details(int id, String email, String name, LocalDate birthDate) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }

    //methods
    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
