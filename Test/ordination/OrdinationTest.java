package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrdinationTest {
    private Ordination o1,o2;
    private Patient p1;

    @BeforeEach
    void setUp() {
        p1 = new Patient("101010-2020","Ulla Jensen",120);
        o1 = new DagligFast(LocalDate.of(2022,1,10),LocalDate.of(2022,1,13),p1);
        o2 = new DagligFast(LocalDate.of(2022,1,10),LocalDate.of(2022,1,10),p1);
    }

    @Test
    void antalDage4Dage() {
        int antalDage = o1.antalDage();
        assertEquals(4,antalDage);
    }

    @Test
    void antalDage1Dag() {
        int antalDage = o2.antalDage();
        assertEquals(1,antalDage);
    }

}