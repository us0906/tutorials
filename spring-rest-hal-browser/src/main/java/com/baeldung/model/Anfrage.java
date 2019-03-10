package com.baeldung.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Anfrage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column (columnDefinition = "VARCHAR", length = 100)
    private String name;

    @Column (columnDefinition = "VARCHAR", length = 100)
    private String vorname;

    @Column (columnDefinition = "VARCHAR", length =  100)
    private String titel;

    @Column(columnDefinition = "VARCHAR", length = 100)
    private String sachbearbeiter;

    @OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Suche suche = new Suche();

    public Anfrage() {

    }

    public Anfrage(@NotNull String name, String vorname, String titel, String sachbearbeiter,
                   Suche suche) {
        this.name = name;
        this.vorname = vorname;
        this.titel = titel;
        this.sachbearbeiter = sachbearbeiter;
        this.suche = suche;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getSachbearbeiter() {
        return sachbearbeiter;
    }

    public void setSachbearbeiter(String sachbearbeiter) {
        this.sachbearbeiter = sachbearbeiter;
    }

    public Suche getSuche() {
        return suche;
    }

    public void setSuche(Suche suche) {
        this.suche = suche;
    }

    @Override
    public String toString() {
        return "Anfrage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                ", titel='" + titel + '\'' +
                ", sachbearbeiter='" + sachbearbeiter + '\'' +
                '}';
    }
}
