package entities;

import javax.persistence.*;

/**
 * Created by Yafei on 05/01/2017.
 */
@Entity
@Table(name = "tier")
@PrimaryKeyJoinColumn(name = "figurid")
public class Tier extends Figur {
    @ManyToOne
    @JoinColumn(name = "besitztVon", foreignKey = @ForeignKey(name = "PERSON_ID_FK"))
    private Person person;

    public Tier() {}
    public Tier(String name, Ort herkunftsort, Person p) {
        super(name, herkunftsort);
        this.person = p;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Tier)) return false;
        if (!super.equals(obj)) return false;

        Tier that = (Tier) obj;
        if (!that.getPerson().equals(this.getPerson())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getPerson() != null ? getPerson().hashCode() : 0);
        return result;
    }
}
