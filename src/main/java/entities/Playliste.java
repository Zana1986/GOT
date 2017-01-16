package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yafei on 07/01/2017.
 */
@Entity
@Table(name = "playliste")
public class Playliste {

    @Id
    @Column(name = "playlisteid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gehoertzu", referencedColumnName = "benutzerid")
    private Benutzer benutzer;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "enthalten",
            joinColumns = {@JoinColumn(name = "playlisteid")},
            inverseJoinColumns = {
                    @JoinColumn(name = "episodenummer", referencedColumnName = "epinummer"),
                    @JoinColumn(name = "nummer", referencedColumnName = "nummer")}
    )
    private List<Episode> episoden = new ArrayList<Episode>();

    public Playliste() {}
    public Playliste(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public List<Episode> getEpisoden() {
        return episoden;
    }

    public void addEpisode(Episode episode) {
        episoden.add(episode);

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Playliste)) return false;

        final Playliste that = (Playliste) obj;
        if (!that.getBenutzer().equals(this.getBenutzer())) return false;
        if (that.getId() != this.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (benutzer != null ? benutzer.hashCode() : 0);
        return result;
    }
}
