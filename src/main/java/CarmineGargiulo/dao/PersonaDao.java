package CarmineGargiulo.dao;

import CarmineGargiulo.entities.Persona;
import CarmineGargiulo.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDao {
    private final EntityManager entityManager;

    public PersonaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(Persona persona){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(persona);
        transaction.commit();
        System.out.println("La persona " + persona.getNome() + " è stato salvato correttamente");
    }

    public Persona getById(String id){
        Persona found = entityManager.find(Persona.class, UUID.fromString(id));
        if(found == null) throw new NotFoundException(id);
        return found;
    }
}
