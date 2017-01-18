package entities;

import javax.persistence.*;

/**
 * Created by Yafei on 05/01/2017.
 */
@Entity
@Table(name = "tier")
@PrimaryKeyJoinColumn(name = "figurid")
public class Tier extends Figur {
    @ManyToOne(cascade = CascadeType.ALL)
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

        final Tier that = (Tier) obj;
        if (!that.getName().equals(this.getName())) return false;
        if (!that.getHerkunftsort().equals(this.getHerkunftsort())) return false;
        if (!that.getPerson().equals(this.getPerson())) return false;
        if (that.getId() != this.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getHerkunftsort() != null ? getHerkunftsort().hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        return result;
    }
}
