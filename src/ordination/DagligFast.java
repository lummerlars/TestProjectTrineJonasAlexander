package ordination;

public class DagligFast extends Ordination {
int[] doser = new int[4];

    @Override
    public double samletDosis() {

        return 0;
    }

    @Override
    public double doegnDosis() {
        int sum = 0;
        for (int i = 0; i < doser.length; i++) {
            sum += doser[i];
        }
        return 0;
    }

    @Override
    public String getType() {
        return "DagligFast";
    }
}
