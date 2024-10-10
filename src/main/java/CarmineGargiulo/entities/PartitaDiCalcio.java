package CarmineGargiulo.entities;

import CarmineGargiulo.Enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "football_matches")
@DiscriminatorValue("Football Game")
@NamedQuery(name = "partiteVinteInCasa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraCasa")
@NamedQuery(name = "partiteVinteInTrasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite")
@NamedQuery(name = "partitePareggiate", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente IS NULL")
public class PartitaDiCalcio extends Evento{
    @Column(name = "home_team", nullable = false)
    private String squadraCasa;

    @Column(name = "away_team", nullable = false)
    private String squadraOspite;

    @Column(name = "winner")
    private String squadraVincente;

    @Column(name = "home_goals", nullable = false)
    private int golSquadraCasa;

    @Column(name = "away_goals", nullable = false)
    private int golSquadraOspite;

    public PartitaDiCalcio(){

    }

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int nrMaxPartecipanti, Location location, String squadraCasa, int golSquadraCasa, String squadraOspite, int golSquadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, nrMaxPartecipanti, location);
        this.squadraCasa = squadraCasa;
        this.golSquadraCasa = golSquadraCasa;
        this.squadraOspite = squadraOspite;
        this.golSquadraOspite = golSquadraOspite;
        if(golSquadraCasa > golSquadraOspite) this.squadraVincente = squadraCasa;
        else if(golSquadraOspite > golSquadraCasa) this.squadraVincente = squadraOspite;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolSquadraCasa() {
        return golSquadraCasa;
    }

    public void setGolSquadraCasa(int golSquadraCasa) {
        this.golSquadraCasa = golSquadraCasa;
    }

    public int getGolSquadraOspite() {
        return golSquadraOspite;
    }

    public void setGolSquadraOspite(int golSquadraOspite) {
        this.golSquadraOspite = golSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golSquadraCasa=" + golSquadraCasa +
                ", golSquadraOspite=" + golSquadraOspite +
                "} " + super.toString();
    }
}
