package entities;

import javax.persistence.*;

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
}
