package CarmineGargiulo;

import CarmineGargiulo.Enums.Genere;
import CarmineGargiulo.Enums.Sesso;
import CarmineGargiulo.Enums.Stato;
import CarmineGargiulo.Enums.TipoEvento;
import CarmineGargiulo.dao.EventoDao;
import CarmineGargiulo.dao.LocationDao;
import CarmineGargiulo.dao.PartecipazioneDao;
import CarmineGargiulo.dao.PersonaDao;
import CarmineGargiulo.entities.*;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        Location stadioMaradona = new Location("Stadio Diego Armando Maradona", "Napoli");
        Location stadioOlimpico = new Location("Stadio Olimpico", "Roma");

      /*  ld.save(stadioMaradona);
        ld.save(stadioOlimpico);*/

        /*ped.save(carmine);
        ped.save(alena);
        ped.save(francesco);

        ld.save(sanSiro);
        ld.save(sanCarlo);
        ld.save(arenaVerona);*/
//        ld.save(casaMia);

        Location sanSiroFromDb = ld.getById("352fd051-7f2c-4e1b-9a70-c2a71553a05e");
        Location casaMiaFromDb = ld.getById("0c37fe7b-ff08-4570-a698-8997e4c09117");
        Location stadioMaradonaFromDb = ld.getById("634374d9-a58d-4834-a008-3e6659d9485c");
        Location stadioOlimpicoFromDb = ld.getById("a6ec20ed-625e-4bc7-86a6-1f9f5682b6c9");
        Persona carmineFromDb = ped.getById("b1a4a3c7-d588-4f65-9587-50e471044f45");
        Persona alenaFromDb = ped.getById("c8fe12b5-be93-4e49-8fb1-21a99fa37a16");
        Persona francescoFromDb = ped.getById("e5e2a27d-6055-4bbd-8890-ec0a126ee64d");

        List<Persona> atleti = new ArrayList<>(Arrays.asList(carmineFromDb, alenaFromDb, francescoFromDb));
        List<Persona> atleti2 = new ArrayList<>(Arrays.asList(carmineFromDb, alenaFromDb));

        Concerto concertoImagine = new Concerto("Imagine Dragons", LocalDate.of(2025, 6, 11),
                "Concerto Imagine Dragons", TipoEvento.PUBBLICO, 50000, stadioMaradonaFromDb, Genere.POP, false);
        Concerto concertoTaylor = new Concerto("Taylor Swift", LocalDate.of(2024, 12, 25),
                "Concerto Taylor Swift", TipoEvento.PUBBLICO, 45000, stadioOlimpicoFromDb, Genere.POP, true);
        Concerto concertoACDC = new Concerto("AC/DC", LocalDate.now(), "Concerto AC/DC",
                TipoEvento.PUBBLICO, 30000, sanSiroFromDb, Genere.ROCK, true);
        Concerto concertoMozart = new Concerto("Concerto Mozart", LocalDate.of(1780, 5, 21),
                "Concerto Mozart", TipoEvento.PRIVATO, 1000, casaMiaFromDb, Genere.CLASSICO, false);
        PartitaDiCalcio InterMilan = new PartitaDiCalcio("Inter-Milan", LocalDate.of(2024, 9, 22),
                "Derby di Milano", TipoEvento.PUBBLICO, 78000, sanSiroFromDb, "Inter", 1, "Milan", 2);
        PartitaDiCalcio MilanLecce = new PartitaDiCalcio("MilanLecce", LocalDate.of(2024, 9, 27),
                "5° giornata di Serie A", TipoEvento.PUBBLICO, 60000, sanSiroFromDb, "Milan", 3, "Lecce", 0);
        PartitaDiCalcio NapoliComo = new PartitaDiCalcio("NapoliComo", LocalDate.of(2024, 10, 4),
                "6° giornata di Serie A", TipoEvento.PUBBLICO, 50000, stadioMaradonaFromDb, "Napoli", 3, "Como", 1);
        PartitaDiCalcio LazioMilan = new PartitaDiCalcio("Lazio-Milan", LocalDate.of(2024, 8, 31),
                "2° giornata di Serie A", TipoEvento.PUBBLICO, 55000, stadioOlimpicoFromDb, "Lazio", 2, "Milan", 2);
        GaraDiAtletica metri100 = new GaraDiAtletica("Gara atletica 100mt", LocalDate.now(), "Bella gara olimpica", TipoEvento.PUBBLICO, 2, stadioOlimpicoFromDb, atleti, 2);
        GaraDiAtletica metri200 = new GaraDiAtletica("Gara atletica 200mt", LocalDate.now(), "Bella gara olimpica 2", TipoEvento.PUBBLICO, 3, stadioMaradonaFromDb, atleti, 1);
        GaraDiAtletica metri300 = new GaraDiAtletica("Gara atletica 300mt", LocalDate.now(), "Bella gara olimpica 3", TipoEvento.PUBBLICO, 4, stadioMaradonaFromDb, atleti2, 0);

        Evento InterMilanFromDb = ed.getById("5787ff9c-4874-4726-a0cd-0c61bfba3704");
        Evento concertoMozartFromDb = ed.getById("13b1d763-4a61-44a1-ab48-b07ef846703e");
        Partecipazione p1 = new Partecipazione(Stato.DA_CONFERMARE, carmineFromDb, InterMilanFromDb);
        Partecipazione p2 = new Partecipazione(Stato.DA_CONFERMARE, alenaFromDb, InterMilanFromDb);
        Partecipazione p3 = new Partecipazione(Stato.CONFERMATA, francescoFromDb, concertoMozartFromDb);
        Partecipazione p4 = new Partecipazione(Stato.DA_CONFERMARE, carmineFromDb, concertoMozartFromDb);
       /* pad.save(p1);
        pad.save(p2);
        pad.save(p3);
        pad.save(p4);*/
       /* ed.save(concertoImagine);
        ed.save(concertoACDC);
        ed.save(concertoMozart);*/
//        ed.save(concertoTaylor);
        /*ed.save(InterMilan);
        ed.save(NapoliComo);
        ed.save(MilanLecce);*/
        /*ed.save(LazioMilan);*/
        /*ed.save(metri300);*/
        ed.getConcertiInStreaming(true).forEach(System.out::println);
        ed.getConcertiInStreaming(false).forEach(System.out::println);
        ed.getConcertiPerGenere(Genere.POP).forEach(System.out::println);
        ed.getPartiteVinteInCasa().forEach(System.out::println);
        ed.getPartiteVinteInTrasferta().forEach(System.out::println);
        ed.getPartitePareggiate().forEach(System.out::println);
        ed.getPartecipazioniDaConfermarePerEvento(InterMilanFromDb).forEach(System.out::println);
        ed.getPartecipazioniDaConfermarePerEvento(concertoMozartFromDb).forEach(System.out::println);
        ed.getGaraDiAtleticaPerVincitore(alenaFromDb).forEach(System.out::println);
        System.out.println("Vediamo quante gare ho fatto");
        ed.getGaraDiAtleticaPerPartecipante(francescoFromDb).forEach(System.out::println);



    }
}
