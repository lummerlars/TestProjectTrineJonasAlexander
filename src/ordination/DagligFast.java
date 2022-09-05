package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DagligFast extends Ordination {
double [] doser = new double[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, Patient patient) {
        super(startDen, slutDen, patient);
    }

    @Override
    public double samletDosis() {
        return antalDage() * doegnDosis();
    }

    @Override
    public double doegnDosis() {
        int sum = 0;
        for (double d : doser) {
            sum += d;
        }
        return sum;
    }

    @Override
    public String getType() {
        return "DagligFast";
    }
}
