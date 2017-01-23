package entities;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Yafei on 05/01/2017.
 */
@Entity
@Table(name = "episode")
@IdClass(EpisodePK.class)
public class Episode {
    @Id
    @Column(name = "nummer")
    private int staffelNummer;
    @Id
    @Column(name = "epinummer")
    private int epiNummer;

    private String titel;

    @Column(name = "inhaltsangabe")
    private String inhaltsAngabe;

    @Column(name = "Erstausstrahlungsdatum")
    private Date erstausstrahlungsDatum;

    @MapsId("staffelNummer")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nummer", referencedColumnName = "nummer")
    private Staffel staffel;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "episode", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Handlungsort> episodeHOrte = new HashSet<Handlungsort>();

    @OneToMany(mappedBy = "episode", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AuftretenIn> owners = new ArrayList<AuftretenIn>();

    @OneToMany(mappedBy = "episode", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Enthalten> episodeOwners = new HashSet<>();

    public Episode() {}
    public Episode(int staffelNummer, int epiNummer, String titel, String inhaltsAngabe, Date erstausstrahlungsDatum, Staffel staffel) {
        this.staffelNummer = staffelNummer;
        this.epiNummer = epiNummer;
        this.titel = titel;
        this.inhaltsAngabe = inhaltsAngabe;
        this.erstausstrahlungsDatum = erstausstrahlungsDatum;
        this.staffel = staffel;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getInhaltsAngabe() {
        return inhaltsAngabe;
    }

    public void setInhaltsAngabe(String inhaltsAngabe) {
        this.inhaltsAngabe = inhaltsAngabe;
    }

    public Date getErstausstrahlungsDatum() {
        return erstausstrahlungsDatum;
    }

    public void setErstausstrahlungsDatum(Date erstausstrahlungsDatum) {
        this.erstausstrahlungsDatum = erstausstrahlungsDatum;
    }

    public Staffel getStaffel() {
        return staffel;
    }

    public void setStaffel(Staffel staffel) {
        this.staffel = staffel;
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

    public List<AuftretenIn> getOwners() {
        return owners;
    }

    public void setEpisodeHOrte(Set<Handlungsort> episodeHOrte) {
        this.episodeHOrte = episodeHOrte;
    }

    public void setOwners(List<AuftretenIn> owners) {
        this.owners = owners;
    }

    public Set<Enthalten> getEpisodeOwners() {
        return episodeOwners;
    }

    public void setEpisodeOwners(Set<Enthalten> episodeOwners) {
        this.episodeOwners = episodeOwners;
    }

    public Set<Handlungsort> getEpisodeHOrte() {
        return episodeHOrte;
    }

    public void addHOrt(Ort hort) {
        Handlungsort episodeHOrt = new Handlungsort(this, hort);
        episodeHOrte.add(episodeHOrt);
        hort.getHoOwners().add(episodeHOrt);
    }

    public void removeHOrt(Ort hort) {
        Handlungsort episodeHOrt = new Handlungsort(this, hort);
        episodeHOrte.remove(episodeHOrt);
        hort.getHoOwners().remove(episodeHOrt);
        episodeHOrt.setOrt(null);
        episodeHOrt.setEpisode(null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Episode)) return false;

        final Episode that = (Episode) obj;
        if (that.staffelNummer != this.staffelNummer) return false;
        if (that.epiNummer != this.epiNummer) return false;
        if (!that.inhaltsAngabe.equals(this.inhaltsAngabe)) return false;
        if (!that.erstausstrahlungsDatum.equals(this.erstausstrahlungsDatum)) return false;
        if (!that.titel.equals(this.titel)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = staffelNummer;
        result = 31 * result + epiNummer;
        result = 31 * result + (inhaltsAngabe != null ? inhaltsAngabe.hashCode() : 0);
        result = 31 * result + (erstausstrahlungsDatum != null ? erstausstrahlungsDatum.hashCode() : 0);
        result = 31 * result + (titel != null ? titel.hashCode() : 0);

        return result;
    }
}
