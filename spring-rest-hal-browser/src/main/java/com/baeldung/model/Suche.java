package com.baeldung.model;

import javax.persistence.*;

@Entity
public class Suche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (columnDefinition = "VARCHAR", length = 100)
    private String bsnr;

    @Column (columnDefinition = "VARCHAR", length = 100)
    private String lanr;

    @Column (columnDefinition = "VARCHAR", length = 100)
    private String geraetNummer;

    @Column (columnDefinition = "VARCHAR", length = 100)
    private String hausnummer;

    @Column (columnDefinition = "VARCHAR", length = 100)
    private String strasse;

    @Column (columnDefinition = "VARCHAR", length = 100)
    private String plz;

    @Column (columnDefinition = "VARCHAR", length = 100)
    private String ort;

    @OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Korrespondenz korrespondenz = new Korrespondenz();

    public Suche() {
    }

    public Suche(String bsnr, String lanr, String geraetNummer, String hausnummer, String strasse, String plz, String ort,
                 Korrespondenz korrespondenz) {
        this.bsnr = bsnr;
        this.lanr = lanr;
        this.geraetNummer = geraetNummer;
        this.hausnummer = hausnummer;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
        this.korrespondenz = korrespondenz;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBsnr() {
        return bsnr;
    }

    public void setBsnr(String bsnr) {
        this.bsnr = bsnr;
    }

    public String getLanr() {
        return lanr;
    }

    public void setLanr(String lanr) {
        this.lanr = lanr;
    }

    public String getGeraetNummer() {
        return geraetNummer;
    }

    public void setGeraetNummer(String geraetNummer) {
        this.geraetNummer = geraetNummer;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Korrespondenz getKorrespondenz() {
        return korrespondenz;
    }

    public void setKorrespondenz(Korrespondenz korrespondenz) {
        this.korrespondenz = korrespondenz;
    }

    @Override
    public String toString() {
        return "Suche{" +
                "id=" + id +
                ", bsnr='" + bsnr + '\'' +
                ", lanr='" + lanr + '\'' +
                ", geraetNummer='" + geraetNummer + '\'' +
                ", strasse='" + strasse + '\'' +
                ", hausnummer=" + hausnummer +
                ", plz='" + plz + '\'' +
                ", ort='" + ort + '\'' +
                '}';
    }
}
