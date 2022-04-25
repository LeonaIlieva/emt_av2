package mk.ukim.finki.av2_emt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String continent;

    public Country() {
    }

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
