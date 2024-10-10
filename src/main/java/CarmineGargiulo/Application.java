package CarmineGargiulo;

import CarmineGargiulo.Enums.Sesso;
import CarmineGargiulo.Enums.Stato;
import CarmineGargiulo.Enums.TipoEvento;
import CarmineGargiulo.dao.EventoDao;
import CarmineGargiulo.dao.LocationDao;
import CarmineGargiulo.dao.PartecipazioneDao;
import CarmineGargiulo.dao.PersonaDao;
import CarmineGargiulo.entities.Evento;
import CarmineGargiulo.entities.Location;
import CarmineGargiulo.entities.Partecipazione;
import CarmineGargiulo.entities.Persona;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Locale;

public class Application {

    private static final Faker faker = new Faker(Locale.ITALY);
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione-eventi");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDao ed = new EventoDao(em);
        LocationDao ld = new LocationDao(em);
        PartecipazioneDao pad = new PartecipazioneDao(em);
        PersonaDao ped = new PersonaDao(em);

        Persona carmine = new Persona("Carmine", "Gargiulo", "ca@ca.com", LocalDate.of(1993, 2, 19), Sesso.M);
        Persona alena = new Persona("Alena", "Pliushchova", "al@al.com", LocalDate.of(1993, 6, 10), Sesso.F);
        Persona francesco = new Persona("Francesco", "Gargiulo", "fr@fr.com", LocalDate.of(1997, 3, 10), Sesso.M);

        Location sanSiro = new Location("Stadio S.Siro", "Milano");
        Location arenaVerona = new Location("Arena di Verona", "Verona");
        Location sanCarlo = new Location("Teatro San Carlo", "Napoli");
        Location casaMia = new Location("Casa mia", "Sant'Agnello");

        /*ped.save(carmine);
        ped.save(alena);
        ped.save(francesco);

        ld.save(sanSiro);
        ld.save(sanCarlo);
        ld.save(arenaVerona);*/
//        ld.save(casaMia);

        Location sanSiroFromDb = ld.getById("352fd051-7f2c-4e1b-9a70-c2a71553a05e");
        Location casaMiaFromDb = ld.getById("0c37fe7b-ff08-4570-a698-8997e4c09117");
        Persona carmineFromDb = ped.getById("b1a4a3c7-d588-4f65-9587-50e471044f45");
        Persona alenaFromDb = ped.getById("c8fe12b5-be93-4e49-8fb1-21a99fa37a16");
        Persona francescoFromDb = ped.getById("e5e2a27d-6055-4bbd-8890-ec0a126ee64d");
        Evento concertoImagine = new Evento("Concerto Imagine Dragons", LocalDate.of(2025, 8, 25), "Concerto", TipoEvento.PUBBLICO, 60000, sanSiroFromDb);
        Evento MilanUdinese = new Evento("Milan-Udinese", LocalDate.of(2024, 10, 18), "Partita di calcio", TipoEvento.PUBBLICO, 70000, sanSiroFromDb);
        Evento cenaFamiglia = new Evento("Cena in famiglia", LocalDate.of(2024, 10, 10), "Cena", TipoEvento.PRIVATO, 3, casaMiaFromDb);


       /* ed.save(concertoImagine);
        ed.save(MilanUdinese);*/
        /*ed.save(cenaFamiglia);*/
        Evento MilanUdineseFromDb = ed.getById("ff47aa7d-ef44-4e71-aab4-377a11612254");
        Evento concertoImagineFromDb = ed.getById("f91d42b3-df9c-4d1c-860b-1fa8ee2e94cb");
        Evento cenaFamigliaFromDb = ed.getById("c85b7500-a10a-490c-a576-962c375d868a");
        Partecipazione p1 = new Partecipazione(Stato.DA_CONFERMARE, carmineFromDb, MilanUdineseFromDb);
        Partecipazione p2 = new Partecipazione(Stato.DA_CONFERMARE, alenaFromDb, MilanUdineseFromDb);
        Partecipazione p3 = new Partecipazione(Stato.DA_CONFERMARE, francescoFromDb, concertoImagineFromDb);
        Partecipazione p4 = new Partecipazione(Stato.CONFERMATA, carmineFromDb, cenaFamigliaFromDb);
        Partecipazione p5 = new Partecipazione(Stato.CONFERMATA, alenaFromDb, cenaFamigliaFromDb);
        Partecipazione p6 = new Partecipazione(Stato.CONFERMATA, francescoFromDb, cenaFamigliaFromDb);
       /* pad.save(p1);
        pad.save(p2);
        pad.save(p3);*/
        /*pad.save(p4);
        pad.save(p5);
        pad.save(p6);*/
        cenaFamigliaFromDb.getPartecipazioneList().forEach(System.out::println);
        carmineFromDb.getPartecipazioneList().forEach(System.out::println);
    }
}
