package controller;

import ordination.Laegemiddel;
import ordination.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ControllerTest {
    private Patient p1,p2,p3,p4,p5;
    private Laegemiddel l1,l2;
    private Storage storage;


    @BeforeEach
     void setUp() {
        storage = new Storage();
        Controller.setStorage(storage);

        p1 = new Patient("102022-1010","Trine Jonasen",0);
        p2 = new Patient("102022-2020","Alexander Trinesen",24);
        p3 = new Patient("102022-3030","Lars Larsen",25);
        p4 = new Patient("102022-4040","Jonas Lars Larsen",120);
        p5 = new Patient("102022-5050","Bo Larsen",121);

        l1 = new Laegemiddel("Acetylsalicylsyre",0.1,0.15,0.16,"styk");
        l2 = new Laegemiddel("Paracetamol",1,1.5,2,"Ml");
    }

    @Test
    void opretPatient(){
        String cpr = "101010-2020";
        String navn = "Allan Poulsen";
        double vaegt = 65;
        Patient patient = Controller.opretPatient(cpr,navn,vaegt);
        assertNotNull(patient);
        assertEquals("101010-2020",patient.getCprnr());
        assertEquals("Allan Poulsen",patient.getNavn());
        ArrayList<Patient> expected = new ArrayList<>();
        expected.add(patient);
        assertEquals(expected,storage.getAllPatienter());
    }


    @Test
    void anbefaletDosisPrDoegnLet() {
        Double ad1 = Controller.anbefaletDosisPrDoegn(p1,l1);
        assertEquals(0.1,ad1);
        ad1 = Controller.anbefaletDosisPrDoegn(p2,l1);
        assertEquals(0.1,ad1);
    }

    @Test
    void anbefaletDosisPrDoegnNormal() {
        Double ad2 = Controller.anbefaletDosisPrDoegn(p3,l2);
        assertEquals(1.5,ad2);
        ad2 = Controller.anbefaletDosisPrDoegn(p4,l2);
        assertEquals(1.5,ad2);
    }

    @Test
    void anbefaletDosisPrDoegnTung() {
        Double ad3 = Controller.anbefaletDosisPrDoegn(p5,l1);
        assertEquals(0.16,ad3);
    }
}