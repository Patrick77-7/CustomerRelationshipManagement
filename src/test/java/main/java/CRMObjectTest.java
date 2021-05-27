package main.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CRMObjectTest {


        Lead lead1 = new Lead("Test Kunde", "+490301234", "email@dkb.de", "DKB AG");
        Lead lead2 = new Lead("Test Kundin", "+49030123456", "email@dkb.de", "DKB AG");
        Lead lead3 = new Lead("Kunde Test", "+490301234987", "email@dkb.de", "DKB AG");


    @Test
    void createID() {

        assertEquals("L1", lead1.getId());
        assertEquals("L2", lead2.getId());
        assertEquals("L3", lead3.getId());

    }

    @Test
    void setId() {
    }
}