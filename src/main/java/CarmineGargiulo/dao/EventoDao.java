package CarmineGargiulo.dao;

import CarmineGargiulo.Enums.Genere;
import CarmineGargiulo.entities.*;
import CarmineGargiulo.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class EventoDao {
    private final EntityManager entityManager;

    public EventoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(Evento evento){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(evento);
        transaction.commit();
        System.out.println("L'evento " + evento.getTitolo() + " è stato salvato correttamente");
    }

    public Evento getById(String id){
        Evento found = entityManager.find(Evento.class, UUID.fromString(id));
        if(found == null) throw new NotFoundException(id);
        return found;
    }

    public void delete(String id){
        Evento found = getById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("L'evento " + found.getTitolo() + " è stato rimosso correttamente");
    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming){
        TypedQuery<Concerto> query = entityManager.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :boolean", Concerto.class);
        query.setParameter("boolean", inStreaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(Genere genere){
        TypedQuery<Concerto> query = entityManager.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa(){
        TypedQuery<PartitaDiCalcio> query = entityManager.createNamedQuery("partiteVinteInCasa", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta(){
        TypedQuery<PartitaDiCalcio> query = entityManager.createNamedQuery("partiteVinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<Partecipazione> getPartecipazioniDaConfermarePerEvento(Evento e){
        TypedQuery<Partecipazione> query = entityManager.createNamedQuery("partecipazioniPerEvento", Partecipazione.class);
        query.setParameter("evento", e);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartitePareggiate(){
        TypedQuery<PartitaDiCalcio> query = entityManager.createNamedQuery("partitePareggiate", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<GaraDiAtletica> getGaraDiAtleticaPerVincitore(Persona p){
        TypedQuery<GaraDiAtletica> query = entityManager.createNamedQuery("GaraPerVincitore", GaraDiAtletica.class);
        query.setParameter("persona", p);
        return query.getResultList();
    }
}
