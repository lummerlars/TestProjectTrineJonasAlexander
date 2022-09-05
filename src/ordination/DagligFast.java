package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DagligFast extends Ordination {
int[] doser = new int[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, Patient patient) {
        super(startDen, slutDen, patient);
    }

    @Override
    public double samletDosis() {
        int antalDoegn = (int) ChronoUnit.DAYS.between(getStartDen(),getSlutDen());
        return antalDoegn * doegnDosis();
    }

    @Override
    public double doegnDosis() {
        int sum = 0;
        for (int d : doser) {
            sum += d;
        }
        return sum;
    }

    @Override
    public String getType() {
        return "DagligFast";
    }
}
