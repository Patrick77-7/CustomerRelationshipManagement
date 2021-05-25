package main.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void createID() {
        Lead lead1 = new Lead("name","03012030xxxx","vorname.nachname@dkb.de","DKB");
        Lead lead2 = new Lead("name2","03012030yyyy","vorname2.nachname2@dkb.de","DKB");
        Lead lead3 = new Lead("name3","03012030zzzz","vornam3.nachname3@dkb.de","DKB");

        Contact cont1 = new Contact(lead1);
        Contact cont2 = new Contact(lead2);
        Contact cont3 = new Contact(lead3);

        assertTrue(cont1.getContactId().equals("C 1"));
        assertTrue(cont2.getContactId().equals("C 2"));
        assertTrue(cont3.getContactId().equals("C 3"));
        Contact cont4 = new Contact(lead1);
        assertTrue(cont4.getContactId().equals("C 4"));

    }

}