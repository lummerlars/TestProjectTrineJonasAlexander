package ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class PNTest {
    private Patient p1;
    private PN pn1,pn2,pn3;

    @BeforeEach
    void setUp() {
        p1 = new Patient("101010-2020","Ulla Jensen",120);
        pn1 = new PN(LocalDate.of(2022,1,10),LocalDate.of(2022,1,13),p1,1);
        pn2 = new PN(LocalDate.of(2022,1,10),LocalDate.of(2022,1,10),p1,2);
    }

    @Test
    void givDosis1PrDag() {
        boolean gd = pn1.givDosis(LocalDate.of(2022,1,12));
        assertEquals(true,gd);
        assertEquals(1,pn1.getGemteDatoer().size());
    }

    @Test
    void givDosis2PrDag() {
        boolean gd = pn1.givDosis(LocalDate.of(2022,1,12));
        assertEquals(true,gd);
        assertEquals(1,pn1.getGemteDatoer().size());

        boolean gd2 = pn1.givDosis(LocalDate.of(2022,1,12));
        assertEquals(true,gd2);
        assertEquals(2,pn1.getGemteDatoer().size());
    }

    @Test
    void givDosisFørStartDato() {
        boolean gd = pn1.givDosis(LocalDate.of(2022,1,9));
        assertEquals(false,gd);
        assertEquals(0,pn1.getGemteDatoer().size());
    }

    @Test
    void givDosisFejlEfterSlutDato() {
        boolean gd = pn1.givDosis(LocalDate.of(2022,1,14));
        assertEquals(false,gd);
        assertEquals(0,pn1.getGemteDatoer().size());
    }

    @Test
    void givDosisPåStartDato() {
        boolean gd = pn1.givDosis(LocalDate.of(2022,1,10));
        assertEquals(true,gd);
        assertEquals(1,pn1.getGemteDatoer().size());
    }

    @Test
    void givDosisPåSlutDato() {
        boolean gd = pn1.givDosis(LocalDate.of(2022,1,13));
        assertEquals(true,gd);
        assertEquals(1,pn1.getGemteDatoer().size());
    }
}