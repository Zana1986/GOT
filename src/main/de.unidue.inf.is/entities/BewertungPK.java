package entities;

import java.io.Serializable;

/**
 * Created by Yafei on 07/01/2017.
 */

public class BewertungPK  implements Serializable {
    private int bewertungid;
    private int benutzerid;

    public BewertungPK() {}
    public BewertungPK(int bewertungid, int benutzerid) {
        this.bewertungid = bewertungid;
        this.benutzerid = benutzerid;
    }

    public int getBewertungid() {
        return bewertungid;
    }

    public void setBewertungid(int bewertungid) {
        this.bewertungid = bewertungid;
    }

    public int getBenutzerid() {
        return benutzerid;
    }

    public void setBenutzerid(int benutzerid) {
        this.benutzerid = benutzerid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof BewertungPK)) return false;

        final BewertungPK that = (BewertungPK) obj;
        if (that.getBewertungid() != this.getBewertungid()) return false;
        if (that.getBenutzerid() != this.getBenutzerid()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = benutzerid;
        result = 31 * result + bewertungid;
        return result;
    }
}
