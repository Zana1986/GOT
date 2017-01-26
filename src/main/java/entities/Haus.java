package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yafei on 05/01/2017.
 */
@Entity
@Table(name = "haus")
public class Haus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hausid")
    private int id;

    @Column(unique = true)
    private String name;
    private String motto;
    private String wappen;

    @OneToOne
    @JoinColumn(name = "sitz", referencedColumnName = "burgid")
    private Burg sitz;

    @OneToMany(mappedBy = "haus", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Angehoert> owners = new HashSet<>();

    @ManyToOne
    @JoinTable(name = "ansehen",
            joinColumns = {@JoinColumn(name = "hausid")},
            inverseJoinColumns = {@JoinColumn(name = "burgid")}
    )
    private Burg burg;

    @OneToMany(mappedBy = "haus", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Beherrschen> orte = new HashSet<>();

    @OneToMany(mappedBy = "haus", fetch = FetchType.EAGER)
    private Set<HausBewertung> hausBewertungen = new HashSet<>();

    public Haus() {}
    public Haus(String name, String motto, String wappen, Burg sitz) {
        this.name = name;
        this.motto = motto;
        this.wappen = wappen;
        this.sitz = sitz;
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

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getWappen() {
        return wappen;
    }

    public void setWappen(String wappen) {
        this.wappen = wappen;
    }

    public Burg getSitz() {
        return sitz;
    }

    public void setSitz(Burg sitz) {
        this.sitz = sitz;
    }

    public Burg getBurg() {
        return burg;
    }

    public void setBurg(Burg burg) {
        this.burg = burg;
    }

    public void setOwners(Set<Angehoert> owners) {
        this.owners = owners;
    }

    public Set<Angehoert> getOwners() {
        return owners;
    }

    public Set<HausBewertung> getHausBewertungen() {
        return hausBewertungen;
    }

    public void setHausBewertungen(Set<HausBewertung> hausBewertungen) {
        this.hausBewertungen = hausBewertungen;
    }

    public Set<Beherrschen> getOrte() {
        return orte;
    }

    public void setOrte(Set<Beherrschen> orte) {
        this.orte = orte;
    }

    public void addOrt(Ort ort, Episode start, Episode end) {
        Beherrschen hausOrt = new Beherrschen(this, ort, start, end);
        orte.add(hausOrt);
        ort.getOwners().add(hausOrt);
    }

    public void removeOrt(Ort ort, Episode start, Episode end) {
        Beherrschen hausOrt = new Beherrschen(this, ort, start, end);
        orte.remove(hausOrt);
        ort.getOwners().remove(hausOrt);
        hausOrt.setHaus(null);
        hausOrt.setOrt(null);
        hausOrt.setStartEpisode(null);
        hausOrt.setEndEpisode(null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Haus)) return false;

        final Haus that = (Haus) obj;
        if (!that.getName().equals(this.getName())) return false;
        if (!that.getMotto().equals(this.getMotto())) return false;
        if (!that.getSitz().equals(this.getSitz())) return false;
        if (!that.getWappen().equals(this.getWappen())) return false;
        if (that.getId() != this.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (motto != null ? motto.hashCode() : 0);
        result = 31 * result + (sitz != null ? sitz.hashCode() : 0);
        result = 31 * result + (wappen != null ? wappen.hashCode() : 0);
        return result;
    }
}
