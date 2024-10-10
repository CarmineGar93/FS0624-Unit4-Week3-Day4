package CarmineGargiulo.entities;

import CarmineGargiulo.Enums.Stato;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipations")
public class Partecipazione {
    @Id
    @GeneratedValue
    @Column(name = "partecipation_id")
    private UUID partecipazioneId;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private Stato stato;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Evento evento;

    public Partecipazione() {

    }

    public Partecipazione(Stato stato, Persona persona, Evento evento) {
        this.stato = stato;
        this.persona = persona;
        this.evento = evento;
    }

    public UUID getPartecipazioneId() {
        return partecipazioneId;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "partecipazioneId=" + partecipazioneId +
                ", stato=" + stato +
                ", persona=" + persona +
                ", evento=" + evento +
                '}';
    }
}
