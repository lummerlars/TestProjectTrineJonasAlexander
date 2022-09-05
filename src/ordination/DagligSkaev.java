package ordination;

import java.time.LocalTime;

public class DagligSkaev extends Ordination {


    public void opretDosis(LocalTime tid, double antal) {

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
