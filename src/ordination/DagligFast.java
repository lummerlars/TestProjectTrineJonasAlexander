package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DagligFast extends Ordination {
    private Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, Patient patient) {
        super(startDen, slutDen, patient);
    }

    public void addDoser(Dosis dosis){
        for (int i = 0; i < doser.length; i++) {
            if (doser[i] == null){
                doser[i] = dosis;
            }
        }
    }

    public Dosis[] getDoser() {
        return doser;
    }

    @Override
    public double samletDosis() {
        return antalDage() * doegnDosis();
    }

    @Override
    public double doegnDosis() {
        int sum = 0;
        for (Dosis d : doser) {
            sum += d.getAntal();
        }
        return sum;
    }

    @Override
    public String getType() {
        return "DagligFast";
    }
}
