package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yafei on 05/01/2017.
 */
@Entity
@Table(name = "burg")
public class Burg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "burgid")
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "standort", referencedColumnName = "ortid")
    private Ort standOrt;

    @OneToMany(mappedBy = "burg", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Haus> haeuser = new ArrayList<Haus>();

    public Burg() {}
    public Burg(String name, Ort standOrt) {
        this.name = name;
        this.standOrt = standOrt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ort getStandOrt() {
        return standOrt;
    }

    public void setStandOrt(Ort standOrt) {
        this.standOrt = standOrt;
    }

    public  List<Haus> getHaeuser() {
        return haeuser;
    }

    public void addHaus(Haus haus) {
        haeuser.add(haus);
        haus.setBurg(this);
    }

    public void removeHaus(Haus haus) {
        haeuser.remove(haus);
        haus.setBurg(null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Burg)) return false;

        final Burg that = (Burg) obj;
        if (that.getId() != this.getId()) return false;
        if (!that.getName().equals(this.getName())) return false;
        if (!that.getStandOrt().equals(this.getStandOrt())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (standOrt != null ? standOrt.hashCode() : 0);
        return result;
    }
}
