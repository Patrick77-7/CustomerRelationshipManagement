package main.java;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    Lead lead1;
    Lead lead2;
    Lead lead4;

    Contact cont1;
    Contact cont2;
    Contact cont3;
    Contact cont4;

    @Test
    void test1InitContact() {
        lead1 = new Lead("name","03012030xxxx","vorname.nachname@dkb.de","DKB");
        lead2 = new Lead("name2","03012030yyyy","vorname2.nachname2@dkb.de","DKB");

        cont1 = new Contact(lead1);
        cont2 = new Contact(lead2);

        assertTrue(cont1.getId().equals("C1"));
        assertTrue(cont2.getId().equals("C2"));
        Contact cont3 = new Contact();
        assertTrue(cont3.getId().equals("C3"));
    }

    @Test
    void test2GetInfo(){
        lead4 = new Lead("name","03012030xxxx","vorname.nachname@dkb.de","DKB");
        cont4 = new Contact(lead4);

        assertEquals("C4;name;03012030xxxx;vorname.nachname@dkb.de;DKB",cont4.getInfo());
    }

}