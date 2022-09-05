package ordination;

import com.sun.javafx.scene.paint.GradientUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {

    private final ArrayList<Dosis> doser = new ArrayList<>();

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Patient patient) {
        super(startDen, slutDen, patient);
    }

    public ArrayList<Dosis> getDoser() {
        return new ArrayList<>(doser);
    }

    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        doser.add(dosis);
    }

    @Override
    public double samletDosis() {
        int day = (int) ChronoUnit.DAYS.between(super.getStartDato(),super.getSlutDato());
        return doegnDosis() * day;
    }

    @Override
    public double doegnDosis() {
        double total = 0;
        for(Dosis d : doser){
            total += d.getAntal();
        }
        return total;
    }

    @Override
    public String getType() {
        return "DagligSkæv";
    }
}
