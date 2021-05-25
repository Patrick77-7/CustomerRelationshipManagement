package main.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeadTest {

    @Test
    void createNewLead() {
        Lead lead1 = new Lead("name","03012030xxxx","vorname.nachname@dkb.de","DKB");
        Lead lead2 = new Lead("name2","03012030yyyy","vorname2.nachname2@dkb.de","DKB");
        Lead lead3 = new Lead("name3","03012030zzzz","vornam3.nachname3@dkb.de","DKB");
        assertTrue(lead1.getLeadId().equals("L 1"));
        assertTrue(lead2.getLeadId().equals("L 2"));
        assertTrue(lead3.getLeadId().equals("L 3"));
    }
}