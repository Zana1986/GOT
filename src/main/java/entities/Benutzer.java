package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yafei on 07/01/2017.
 */
@Entity
@Table(name = "benutzer")
public class Benutzer {

    @Id
    @Column(name = "benutzerid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String passwort;

    @Column(name = "loginkennung", unique = true)
    private String loginKennung;

    @OneToMany(mappedBy = "benutzer", fetch = FetchType.EAGER)
    private Set<Bewertung> bewertungen = new HashSet<>();

//    // Stack Over
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "benutzer")
//    private Set<Playliste> playlisten = new HashSet<>();

    public Benutzer() {}
    public Benutzer(String name, String passwort, String loginKennung) {
        this.name = name;
        this.passwort = passwort;
        this.loginKennung = loginKennung;
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

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getLoginKennung() {
        return loginKennung;
    }

    public void setLoginKennung(String loginKennung) {
        this.loginKennung = loginKennung;
    }

    public Set<Bewertung> getBewertungen() {
        return bewertungen;
    }

    public void setBewertungen(Set<Bewertung> bewertungen) {
        this.bewertungen = bewertungen;
    }

//    public Set<Playliste> getPlaylisten() {
//        return playlisten;
//    }
//
//    public void setPlaylisten(Set<Playliste> playlisten) {
//        this.playlisten = playlisten;
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Benutzer)) return false;

        final Benutzer that = (Benutzer) obj;
        if (that.getId() != this.getId()) return false;
        if (!that.getLoginKennung().equals(this.getLoginKennung())) return false;
        if (!that.getName().equals(this.getName())) return false;
        if (!that.getPasswort().equals(this.getPasswort())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + getId();
        result = result * 31 + (getName() != null ? getName().hashCode() : 0);
        result = result * 31 + (getPasswort() != null ? getPasswort().hashCode() : 0);
        result = result * 31 + (getLoginKennung() != null ? getLoginKennung().hashCode() : 0);

        return result;
    }
}
