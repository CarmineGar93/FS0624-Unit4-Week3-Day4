package CarmineGargiulo.entities;

import CarmineGargiulo.Enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "athletics_competitions")
@DiscriminatorValue("Athletic Competition")
@NamedQuery(name = "GaraPerVincitore", query = "SELECT g FROM GaraDiAtletica g WHERE g.vincitore = :persona")
public class GaraDiAtletica extends Evento {


    @ManyToMany
    @JoinTable(name = "athlet_competition",
            joinColumns = @JoinColumn(name = "competition_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "athlet_id", nullable = false))
    private List<Persona> atleti;

    @OneToOne
    @JoinColumn(name = "winner_id", nullable = false)
    private Persona vincitore;

    public GaraDiAtletica(){

    }

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int nrMaxPartecipanti, Location location, List<Persona> atleti, int vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, nrMaxPartecipanti, location);
        this.atleti = atleti;
        this.vincitore = atleti.get(vincitore);
    }

    public List<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(List<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(int vincitore) {
        this.vincitore = this.atleti.get(vincitore);
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                "} " + super.toString();
    }
}
