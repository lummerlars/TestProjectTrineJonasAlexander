package ordination;

import com.sun.javafx.scene.paint.GradientUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {

    private final ArrayList<Dosis> dosises = new ArrayList<>();

    public DagligSkaev(LocalDate startDen, LocalDate slutDen) {
        super(startDen, slutDen);
    }

    public ArrayList<Dosis> getDosises() {
        return new ArrayList<>(dosises);
    }

    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        dosises.add(dosis);
    }

    @Override
    public double samletDosis() {
        int day = (int) ChronoUnit.DAYS.between(super.getStartDen(),super.getSlutDen());
        return doegnDosis() * day;
    }

    @Override
    public double doegnDosis() {
        double total = 0;
        for(Dosis d : dosises){
            total += d.getAntal();
        }
        return total;
    }

    @Override
    public String getType() {
        return "DagligSkæv";
    }
}
