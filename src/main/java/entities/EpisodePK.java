package entities;

import java.io.Serializable;

/**
 * Created by Yafei on 06/01/2017.
 */
public class EpisodePK implements Serializable {
    private int staffelNummer;
    private int epiNummer;

    public EpisodePK() {}
    public EpisodePK(int staffelNummer, int epiNummer) {
        this.staffelNummer = staffelNummer;
        this.epiNummer = epiNummer;
    }

    public int getStaffelNummer() {
        return staffelNummer;
    }

    public void setStaffelNummer(int straffelNummer) {
        this.staffelNummer = straffelNummer;
    }

    public int getEpiNummer() {
        return epiNummer;
    }

    public void setEpiNummer(int epiNummer) {
        this.epiNummer = epiNummer;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof EpisodePK)) return false;

        final EpisodePK that = (EpisodePK) obj;
        if (that.staffelNummer != this.staffelNummer) return false;
        if (that.epiNummer != this.epiNummer) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + epiNummer;
        return result;
    }
}
