package CarmineGargiulo.entities;

import CarmineGargiulo.Enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "events")
public class Evento {
    @Id
    @GeneratedValue
    @Column(name = "evento_id")
    private UUID eventoId;

    @Column(name = "title" , nullable = false)
    private String titolo;

    @Column(name = "event_date", nullable = false)
    private LocalDate dataEvento;

    @Column(name = "description")
    private String descrizione;

    @Column(name = "event_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @Column(name = "max_participants")
    private int nrMaxPartecipanti;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> partecipazioneList = new ArrayList<>();

    public Evento(){

    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int nrMaxPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.nrMaxPartecipanti = nrMaxPartecipanti;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public UUID getId() {
        return eventoId;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNrMaxPartecipanti() {
        return nrMaxPartecipanti;
    }

    public void setNrMaxPartecipanti(int nrMaxPartecipanti) {
        this.nrMaxPartecipanti = nrMaxPartecipanti;
    }

    public List<Partecipazione> getPartecipazioneList() {
        return partecipazioneList;
    }

    public void setPartecipazioneList(List<Partecipazione> partecipazioneList) {
        this.partecipazioneList = partecipazioneList;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "eventoId=" + eventoId +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", nrMaxPartecipanti=" + nrMaxPartecipanti +
                ", location=" + location +
                '}';
    }
}
