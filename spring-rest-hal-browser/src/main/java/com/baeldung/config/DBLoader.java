package com.baeldung.config;

import com.baeldung.data.AnfrageRepository;
import com.baeldung.data.BookRepository;
import com.baeldung.data.SucheRepository;
import com.baeldung.model.Anfrage;
import com.baeldung.model.Book;
import com.baeldung.model.Korrespondenz;
import com.baeldung.model.Suche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.IntStream;

@Component
public class DBLoader implements ApplicationRunner {

    private final BookRepository bookRepository;
    private final AnfrageRepository anfrageRepository;
    private final SucheRepository sucheRepository;

    @Autowired
    DBLoader(BookRepository bookRepository, AnfrageRepository anfrageRepository,
             SucheRepository sucheRepository) {
        this.bookRepository = bookRepository;
        this.anfrageRepository = anfrageRepository;
        this.sucheRepository = sucheRepository;
    }


    public void run(ApplicationArguments applicationArguments) throws Exception {
        initBookRepository();
        initAnfrageRepository();
    }

    private void initAnfrageRepository() {

        String[] vornamen = {
                "Peter", "Paul", "Mary", "John", "Bruce", "Ringo", "George", "EmmyLou"
        };

        String[] namen = {
                "Harrison", "Lennon", "Harris", "Springsteen", "Cohen"
        };

        IntStream.range(0, 100).
                forEach(i -> {

                    Korrespondenz korrespondenz = new Korrespondenz("", "", "", "", "", "");

                    String bsnr = "1213456700";
                    String lanr = "1234567";
                    String geraetnummer = "xxxxyyyyzzz";
                    String strasse = "Menzingerstrasse";
                    String hausnummer = "1";
                    String plz = "80638";
                    String ort = "München";

                    Suche suche = new Suche(bsnr, lanr, geraetnummer, hausnummer, strasse, plz, ort, korrespondenz);

                    String name = namen[i % namen.length];
                    String vorname = vornamen[i % vornamen.length];
                    String titel = "Dr. med,";
                    String sachbearbeiter = "sach" + i;
                    Anfrage anfrage = new Anfrage(name, vorname, titel, sachbearbeiter, suche);
                    anfrageRepository.save(anfrage);
                    System.out.println(anfrage);
                });
    }

    private void initBookRepository() {
        String[] templates = {
                "Up and running with %s",
                "%s Basics",
                "%s for Beginners",
                "%s for Neckbeards",
                "Under the hood: %s",
                "Discovering %s",
                "A short guide to %s",
                "%s with Baeldung"
        };

        String[] buzzWords = {
                "Spring REST Data",
                "Java 9",
                "Scala",
                "Groovy",
                "Hibernate",
                "Spring HATEOS",
                "The HAL Browser",
                "Spring webflux",
        };

        String[] authorFirstName = {
                "John %s",
                "Steve %s",
                "Samantha %s",
                "Gale %s",
                "Tom %s"
        };

        String[] authorLastName = {
                "Giles",
                "Gill",
                "Smith",
                "Armstrong"
        };

        String[] blurbs = {
                "It was getting dark when the %s %s",
                "Scott was nearly there when he heard that a %s %s",
                "Diana was a lovable Java coder until the %s %s",
                "The gripping story of a small %s and the day it %s"
        };

        String[] blublMiddles = {
                "distaster",
                "dog",
                "cat",
                "turtle",
                "hurricane"
        };

        String[] end = {
                "hit the school",
                "memorised pi to 100 decimal places!",
                "became a world champion armwrestler",
                "became a Java REST master!!"
        };

        Random random = new Random();

        IntStream.range(0, 100)
                .forEach(i -> {
                    String template = templates[i % templates.length];
                    String buzzword = buzzWords[i % buzzWords.length];
                    String blurbStart = blurbs[i % blurbs.length];
                    String middle = blublMiddles[i % blublMiddles.length];
                    String ending = end[i % end.length];
                    String blurb = String.format(blurbStart, middle, ending);
                    String firstName = authorFirstName[i % authorFirstName.length];
                    String lastname = authorLastName[i % authorLastName.length];
                    Book book = new Book(String.format(template, buzzword), String.format(firstName, lastname), blurb, random.nextInt(1000 - 200) + 200);

                    bookRepository.save(book);

                    System.out.println(book);

                });
    }
}
