package ordination;

public class DagligFast extends Ordination {
int[] doser = new int[4];

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
        return "DagligFast";
    }
}
