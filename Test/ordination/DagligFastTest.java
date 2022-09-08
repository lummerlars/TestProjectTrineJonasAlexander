package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DagligFastTest {
    private Patient p1;
    private DagligFast d1,d2;
    private Dosis dosis1,dosis2,dosis3,dosis4,dosis5,dosis6,dosis7,dosis8;

    @BeforeEach
    void setUp() {
        dosis1 = new Dosis(LocalTime.of(8,0),1);
        dosis2 = new Dosis(LocalTime.of(12,0),2);
        dosis3 = new Dosis(LocalTime.of(18,0),3);
        dosis4 = new Dosis(LocalTime.of(23,59),4);

        dosis5 = new Dosis(LocalTime.of(8,0),0.1);
        dosis6 = new Dosis(LocalTime.of(12,0),0.2);
        dosis7 = new Dosis(LocalTime.of(18,0),0.3);
        dosis8 = new Dosis(LocalTime.of(23,59),0.4);

        p1 = new Patient("101010-2020","Ulla Jensen",120);
        d1 = new DagligFast(LocalDate.of(2022,1,10),LocalDate.of(2022,1,13),p1);
        d2 = new DagligFast(LocalDate.of(2022,1,10),LocalDate.of(2022,1,10),p1);

        d1.addDoser(dosis1,0);
        d1.addDoser(dosis2,1);
        d1.addDoser(dosis3,2);
        d1.addDoser(dosis4,3);

        d2.addDoser(dosis5,0);
        d2.addDoser(dosis6,1);
        d2.addDoser(dosis7,2);
        d2.addDoser(dosis8,3);
    }

    @Test
    void doegnDosisEvenNumber() {
        double dd = d1.doegnDosis();
        assertEquals(10,dd);
    }

    @Test
    void doegnDosisUnevenNumber() {
        double dd = d2.doegnDosis();
        assertEquals(1,dd,0.0001);
    }
}