package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DagligSkaevTest {
    private Patient p1;
    private DagligSkaev d1,d2,d3;

    @BeforeEach
    void setUp() {
        p1 = new Patient("101010-2020","Ulla Jensen",120);
        d1 = new DagligSkaev(LocalDate.of(2022,1,10),LocalDate.of(2022,1,13),p1);
        d1.opretDosis(LocalTime.of(8,0),4);
        d1.opretDosis(LocalTime.of(12,0),2);
        d1.opretDosis(LocalTime.of(18,0),4);

        d2 = new DagligSkaev(LocalDate.of(2022,1,10),LocalDate.of(2022,1,10),p1);
        d2.opretDosis(LocalTime.of(8,0),4);
        d2.opretDosis(LocalTime.of(12,0),2);
        d2.opretDosis(LocalTime.of(18,0),4);

        d3 = new DagligSkaev(LocalDate.of(2022,1,10),LocalDate.of(2022,1,13),p1);
        d3.opretDosis(LocalTime.of(8,0),0.1);
        d3.opretDosis(LocalTime.of(12,0),0.2);
        d3.opretDosis(LocalTime.of(18,0),0.3);
    }

    @Test
    void samletDosis4Dage() {
        double sd = d1.samletDosis();
        assertEquals(40,sd);
    }

    @Test
    void samletDosis1Dag() {
        double sd = d2.samletDosis();
        assertEquals(10,sd);
    }

    @Test
    void samletDosisMl() {
        double sd = d3.samletDosis();
        assertEquals(2.4,sd,0.0001);
    }
}