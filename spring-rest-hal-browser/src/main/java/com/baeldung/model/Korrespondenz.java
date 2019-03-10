package com.baeldung.model;

import javax.persistence.*;

@Entity
public class Korrespondenz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "VARCHAR", length = 100)
    private String anschrift1;

    @Column (columnDefinition = "VARCHAR", length = 100)
    private String anschrift2;

    @Column (columnDefinition = "VARCHAR", length = 100)
    private String anschrift3;

    @Column (columnDefinition = "VARCHAR", length = 100)
    private String anschrift4;

    @Column (columnDefinition = "VARCHAR", length = 100)
    private String anrede1;

    @Column (columnDefinition = "VARCHAR", length = 100)
    private String anrede2;

    public Korrespondenz() {
    }

    public Korrespondenz(String anschrift1, String anschrift2, String anschrift3, String anschrift4, String anrede1, String anrede2) {
        this.anschrift1 = anschrift1;
        this.anschrift2 = anschrift2;
        this.anschrift3 = anschrift3;
        this.anschrift4 = anschrift4;
        this.anrede1 = anrede1;
        this.anrede2 = anrede2;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnschrift1() {
        return anschrift1;
    }

    public void setAnschrift1(String anschrift1) {
        this.anschrift1 = anschrift1;
    }

    public String getAnschrift2() {
        return anschrift2;
    }

    public void setAnschrift2(String anschrift2) {
        this.anschrift2 = anschrift2;
    }

    public String getAnschrift3() {
        return anschrift3;
    }

    public void setAnschrift3(String anschrift3) {
        this.anschrift3 = anschrift3;
    }

    public String getAnschrift4() {
        return anschrift4;
    }

    public void setAnschrift4(String anschrift4) {
        this.anschrift4 = anschrift4;
    }

    public String getAnrede1() {
        return anrede1;
    }

    public void setAnrede1(String anrede1) {
        this.anrede1 = anrede1;
    }

    public String getAnrede2() {
        return anrede2;
    }

    public void setAnrede2(String anrede2) {
        this.anrede2 = anrede2;
    }

    @Override
    public String toString() {
        return "Korrespondenz{" +
                "id=" + id +
                ", anschrift1='" + anschrift1 + '\'' +
                ", anschrift2='" + anschrift2 + '\'' +
                ", anschrift3='" + anschrift3 + '\'' +
                ", anschrift4='" + anschrift4 + '\'' +
                ", anrede1='" + anrede1 + '\'' +
                ", anrede2='" + anrede2 + '\'' +
                '}';
    }
}
