package CarmineGargiulo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private UUID locationId;

    @Column(name = "name")
    private String nome;

    @Column(name = "city")
    private String citta;

    @OneToMany(mappedBy = "location")
    private List<Evento> eventoList = new ArrayList<>();

    public Location() {
    }

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public UUID getLocationId() {
        return locationId;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
