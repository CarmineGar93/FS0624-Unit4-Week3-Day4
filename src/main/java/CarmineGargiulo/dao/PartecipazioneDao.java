package CarmineGargiulo.dao;

import CarmineGargiulo.entities.Partecipazione;
import CarmineGargiulo.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioneDao {
    private final EntityManager entityManager;

    public PartecipazioneDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(Partecipazione partecipazione){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(partecipazione);
        transaction.commit();
        System.out.println("La partecipazione è stato salvata correttamente");
    }

    public Partecipazione getById(String id){
        Partecipazione found = entityManager.find(Partecipazione.class, UUID.fromString(id));
        if(found == null) throw new NotFoundException(id);
        return found;
    }
}
