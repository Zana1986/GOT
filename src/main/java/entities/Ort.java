package entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Yafei on 05/01/2017.
 */
@Entity
@Table(name = "ort")
public class Ort {
    @Id
    @Column(name = "ortid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ortname")
    private String ortName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ort", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Handlungsort> hoOwners = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ort", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Beherrschen> owners = new HashSet<Beherrschen>();

    public Ort() {}
    public Ort(String ortName) {
        this.ortName = ortName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrtName() {
        return ortName;
    }

    public void setOrtName(String ortName) {
        this.ortName = ortName;
    }

    public Set<Beherrschen> getOwners() {
        return owners;
    }

    public Set<Handlungsort> getHoOwners() {
        return hoOwners;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Ort)) return false;

        final Ort that = (Ort) obj;
        if (!that.getOrtName().equals(this.getOrtName())) return false;
        if (that.getId() != this.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ortName != null ? ortName.hashCode() : 0);
        return result;
    }
}
