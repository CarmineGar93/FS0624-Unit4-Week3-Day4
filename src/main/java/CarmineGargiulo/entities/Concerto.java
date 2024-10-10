package CarmineGargiulo.entities;

import CarmineGargiulo.Enums.Genere;
import CarmineGargiulo.Enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "concerts")
@DiscriminatorValue("Concert")
public class Concerto extends Evento{
    @Column(name = "genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private Genere genere;

    @Column(name = "in_streaming",nullable = false)
    private boolean inStreaming;

    public Concerto(){

    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int nrMaxPartecipanti, Location location, Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, nrMaxPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                "} " + super.toString();
    }
}
