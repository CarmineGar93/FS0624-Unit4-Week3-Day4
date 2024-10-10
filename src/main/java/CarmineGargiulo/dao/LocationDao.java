package CarmineGargiulo.dao;

import CarmineGargiulo.entities.Location;
import CarmineGargiulo.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;


public class LocationDao {
    private final EntityManager entityManager;

    public LocationDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(Location location){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(location);
        transaction.commit();
        System.out.println("La location " + location.getNome() + " è stato salvato correttamente");
    }

    public Location getById(String id){
        Location found = entityManager.find(Location.class, UUID.fromString(id));
        if(found == null) throw new NotFoundException(id);
        return found;
    }
}
