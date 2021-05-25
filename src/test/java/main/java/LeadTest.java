package main.java;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class LeadTest {

    @Test
    void test1SetLeadID() {
        Lead lead1= new Lead("name","03012030xxxx","vorname.nachname@dkb.de","DKB");
        Lead lead2= new Lead("name2","03012030yyyy","vorname2.nachname2@dkb.de","DKB");
        Lead lead3= new Lead("name3","03012030zzzz","vorname3.nachname3@dkb.de","DKB");


        assertTrue(lead1.getLeadId().equals("L 1"));
        assertTrue(lead2.getLeadId().equals("L 2"));
        assertTrue(lead3.getLeadId().equals("L 3"));

    }

    @Test
    void test2GetInfo(){
        Lead lead4= new Lead("name","03012030xxxx","vorname.nachname@dkb.de","DKB");
        Lead lead5= new Lead("name2","03012030yyyy","vorname2.nachname2@dkb.de","DKB");
        Lead lead6= new Lead("name3","03012030zzzz","vorname3.nachname3@dkb.de","DKB");


        assertTrue(lead4.getInfo().equals(lead4.getLeadId() + ";name;03012030xxxx;vorname.nachname@dkb.de;DKB"));
        assertTrue(lead5.getInfo().equals(lead5.getLeadId() + ";name2;03012030yyyy;vorname2.nachname2@dkb.de;DKB"));
        assertTrue(lead6.getInfo().equals(lead6.getLeadId() + ";name3;03012030zzzz;vorname3.nachname3@dkb.de;DKB"));
    }

    @Test
    void test3ToString(){
        Lead lead6= new Lead("name","03012030xxxx","vorname.nachname@dkb.de","DKB");

        String testString = new String();

        testString = "Lead{" +
                    "Id='" + lead6.getLeadId() + '\'' +
                    ", Name ='" + "name" + '\'' +
                    ", Phone Number='" + "03012030xxxx" + '\'' +
                    ", Email Address='" + "vorname.nachname@dkb.de" + '\'' +
                    ", Company Name='" + "DKB" + '\'' +
                    '}';

        assertTrue(lead6.toString().equals(testString));
    }

}