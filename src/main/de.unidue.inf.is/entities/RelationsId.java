package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Yafei on 13/01/2017.
 */
@Embeddable
public class RelationsId implements Serializable {

    @Column(name = "figurida", nullable = false)
    private int figurida;
    @Column(name = "figuridb", nullable = false)
    private int figuridb;


    public RelationsId() {}
    public RelationsId(int figurida, int figuridb) {
        this.figurida = figurida;
        this.figuridb = figuridb;
    }

    public int getFigurida() {
        return figurida;
    }

    public void setFigurida(int figurida) {
        this.figurida = figurida;
    }

    public int getFiguridb() {
        return figuridb;
    }

    public void setFiguridb(int figuridb) {
        this.figuridb = figuridb;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof RelationsId)) return false;

        RelationsId that = (RelationsId) obj;
        if (that.getFigurida() != this.getFigurida()) return false;
        if (that.getFiguridb() != this.getFiguridb()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = figurida;
        result = 31 * result + figuridb;

        return result;
    }
}
