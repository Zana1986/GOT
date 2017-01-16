package entities;

import com.sun.org.apache.regexp.internal.RE;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yafei on 12/01/2017.
 */
@Entity
@Table(name = "beziehung")
public class Relation implements Serializable {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "figurida", column = @Column(name = "figurida", nullable = false)),
            @AttributeOverride(name = "figuridb", column = @Column(name = "figuridb", nullable = false)) })
    private RelationsId id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "figurida", nullable = false, insertable = false, updatable = false)
    private Person personen;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "figuridb", nullable = false, insertable = false, updatable = false)
    private Person freunde;

    @Column(name = "beziehungstyp")
    private String relationsTyp;

    public Relation() {}

    public Relation(RelationsId id, Person personen, Person freunde) {
        this.id = id;
        this.personen = personen;
        this.freunde = freunde;
    }

    public Relation(RelationsId id, Person freunde, Person personen, String relationsTyp) {
        this.id = id;
        this.freunde = freunde;
        this.personen = personen;
        this.relationsTyp = relationsTyp;
    }

    public RelationsId getId() {
        return id;
    }

    public void setId(RelationsId id) {
        this.id = id;
    }

    public Person getFreunde() {
        return freunde;
    }

    public void setFreunde(Person freunde) {
        this.freunde = freunde;
    }

    public Person getPersonen() {
        return personen;
    }

    public void setPersonen(Person personen) {
        this.personen = personen;
    }

    public String getRelationsTyp() {
        return relationsTyp;
    }

    public void setRelationsTyp(String relationsTyp) {
        this.relationsTyp = relationsTyp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Relation)) return false;

        Relation that = (Relation) obj;
        if (!that.getFreunde().equals(this.getFreunde())) return false;
        if (!that.getPersonen().equals(this.getPersonen())) return false;
        if (!that.getRelationsTyp().equals(this.getRelationsTyp())) return false;
        if (!that.getId().equals(this.getId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personen != null ? personen.hashCode() : 0;
        result = 31 * result + (freunde != null ? freunde.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (relationsTyp != null ? relationsTyp.hashCode() : 0);

        return result;
    }
}
