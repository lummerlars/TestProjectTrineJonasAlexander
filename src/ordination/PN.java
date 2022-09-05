package ordination;

import javax.management.AttributeNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class PN extends Ordination {
    private double antalEnheder;
    private List<LocalDate> gemteDatoer;

    public PN(LocalDate startDen, LocalDate slutDen,Patient patient, double antalEnheder) {
        super(startDen, slutDen,patient);
        this.antalEnheder = antalEnheder;
        gemteDatoer = null;
    }


    /**
     * Registrer, at der er givet en dosis paa dagen givesDen.
     * Returner true, hvis givesDen er inden for ordinationens gyldighedsperiode, og datoen huskes.
     * Returner false ellers, og datoen givesDen ignoreres.
     */
    public boolean givDosis(LocalDate givesDen) {
        LocalDate startDate = super.getStartDen();
        LocalDate slutDate = super.getSlutDen();
        if (givesDen.isAfter(startDate) && givesDen.isBefore(slutDate)){
            for (LocalDate date : gemteDatoer){
                if (givesDen != date){
                    gemteDatoer.add(givesDen);
                    return true;
                }
            }
        }
        return false;
    }

    /** Returner antal gange ordinationen er anvendt. */
    public int getAntalGangeGivet() {
        int antalDage = 0;
        for (LocalDate date : gemteDatoer){
            antalDage++;
        }
        return antalDage;
    }

    @Override
    public double samletDosis() {
        return doegnDosis() * getAntalGangeGivet();
    }

    @Override
    public double doegnDosis() {
        int daysBetween = (int)ChronoUnit.DAYS.between(super.getStartDen(),super.getSlutDen());
        return (getAntalGangeGivet() * antalEnheder) / daysBetween ;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    @Override
    public String getType() {
        return "PN";
    }
}
