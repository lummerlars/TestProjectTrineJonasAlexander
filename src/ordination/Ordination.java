package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public abstract class Ordination {
    private LocalDate startDen;
    private LocalDate slutDen;
    private Laegemiddel laegemiddel;

    public Ordination(LocalDate startDen, LocalDate slutDen, Patient patient) {
        this.startDen = startDen;
        this.slutDen = slutDen;
        patient.addOrdination(this);
    }

    public Laegemiddel getLaegemiddel() {
        return laegemiddel;
    }

    public void setLaegemiddel(Laegemiddel laegemiddel) {
        this.laegemiddel = laegemiddel;
    }

    public void removeLaegemiddel(){
        this.laegemiddel = null;
    }

    public LocalDate getStartDato() {
        return startDen;
    }

    public LocalDate getSlutDato() {
        return slutDen;
    }

    /** Returner antal hele dage mellem startdato og slutdato. Begge dage inklusive. */
    public int antalDage() {
        return (int) ChronoUnit.DAYS.between(startDen, slutDen) + 1;
    }

    @Override
    public String toString() {
        return startDen.toString();
    }

    /** Returner den totale dosis, der er givet i den periode ordinationen er gyldig. */
    public abstract double samletDosis();

    /** Returner den gennemsnitlige dosis givet pr dag i den periode, ordinationen er gyldig. */
    public abstract double doegnDosis();

    /** Returner ordinationstypen som en String. */
    public abstract String getType();
}
