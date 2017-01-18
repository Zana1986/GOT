package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yafei on 05/01/2017.
 */
@Entity
@Table(name = "figur")
@Inheritance(strategy = InheritanceType.JOINED)
public class Figur implements Serializable {
    @Id
    @Column(name = "figurid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    //1: Person, 2:Tier
    private int type;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="herkunftsort", referencedColumnName = "ortid")
    private Ort herkunftsort;

    @OneToMany(mappedBy = "figur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AuftretenIn> episoden = new ArrayList<AuftretenIn>();

    public Figur() {}
    public Figur(String name, Ort herkunftsort) {
        this.name = name;
        this.herkunftsort = herkunftsort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ort getHerkunftsort() {
        return herkunftsort;
    }

    public void setHerkunftsort(Ort herkunftsort) {
        this.herkunftsort = herkunftsort;
    }

    public List<AuftretenIn> getEpisoden() {
        return episoden;
    }

    public void addEpisode(Episode episode) {
        System.out.println("Figur ID: " + this.getId());
        AuftretenIn figurInEpisode = new AuftretenIn(this, episode);
        episoden.add(figurInEpisode);
        episode.getOwners().add(figurInEpisode);
    }

    public void removeEpisode(Episode episode) {
        AuftretenIn figurInEpisode = new AuftretenIn(this, episode);
        episode.getOwners().remove(figurInEpisode);
        episoden.remove(figurInEpisode);
        figurInEpisode.setEpisode(null);
        figurInEpisode.setFigur(null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Figur)) return false;

        final Figur that = (Figur) obj;
        if (that.getName() != this.getName()) return false;
        if (!that.getHerkunftsort().equals(this.getHerkunftsort())) return false;
        if (that.getId() != this.getId()) return false;
        if (that.getType() != this.getType()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (herkunftsort != null ? herkunftsort.hashCode() : 0);
        result = 31 * result + type;
        return result;
    }
}
