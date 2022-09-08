package ordination;

import javax.management.AttributeNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class PN extends Ordination {
    private double antalEnheder;
    private List<LocalDate> gemteDatoer = new ArrayList<>();

    public PN(LocalDate startDen, LocalDate slutDen,Patient patient, double antalEnheder) {
        super(startDen, slutDen,patient);
        this.antalEnheder = antalEnheder;
    }


    /**
     * Registrer, at der er givet en dosis paa dagen givesDen.
     * Returner true, hvis givesDen er inden for ordinationens gyldighedsperiode, og datoen huskes.
     * Returner false ellers, og datoen givesDen ignoreres.
     */
    public boolean givDosis(LocalDate givesDen) {
        LocalDate startDate = super.getStartDato();
        LocalDate slutDate = super.getSlutDato();
        if ((givesDen.isEqual(startDate) || givesDen.isAfter(startDate)) && (givesDen.isEqual(slutDate) || givesDen.isBefore(slutDate))){
            gemteDatoer.add(givesDen);
            return true;
        }
        return false;
    }

    /** Returner antal gange ordinationen er anvendt. */
    public int getAntalGangeGivet() {
        return gemteDatoer.size();
    }

    public List<LocalDate> getGemteDatoer() {
        return gemteDatoer;
    }

    @Override
    public double samletDosis() {
        return doegnDosis() * getAntalGangeGivet();
    }

    @Override
    public double doegnDosis() {
        return (getAntalGangeGivet() * antalEnheder) / super.antalDage() ;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    @Override
    public String getType() {
        return "PN";
    }
}
