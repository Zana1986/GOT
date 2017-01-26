package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @ManyToOne
    @JoinColumn(name = "gehoertzu", referencedColumnName = "benutzerid")
    private Benutzer benutzer;

    @OneToMany(mappedBy = "playliste",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Enthalten> episoden = new HashSet<>();

    public Playliste() {}

    public Playliste(String name, Benutzer benutzer) {
        this.name = name;
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

    public Set<Enthalten> getEpisoden() {
        return episoden;
    }

    public void setEpisoden(Set<Enthalten> episoden) {
        this.episoden = episoden;
    }

    public void addEpisode(Episode episode) {
        Enthalten listeEpisode = new Enthalten(this, episode);
        episoden.add(listeEpisode);
        episode.getEpisodeOwners().add(listeEpisode);
    }

    public void removeEpisode(Episode episode) {
        Enthalten listeEpisode = new Enthalten(this, episode);
        episoden.remove(listeEpisode);
        episode.getEpisodeOwners().remove(listeEpisode);
        listeEpisode.setEpisode(null);
        listeEpisode.setPlayliste(null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Playliste)) return false;

        final Playliste that = (Playliste) obj;
        if (!that.getBenutzer().equals(this.getBenutzer())) return false;
        if (that.getId() != this.getId()) return false;
        if (!that.getName().equals(this.getName())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (benutzer != null ? benutzer.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
