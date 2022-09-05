package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
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
        return 0;
    }

    @Override
    public double doegnDosis() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }
}
