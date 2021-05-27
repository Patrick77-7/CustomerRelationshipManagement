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


        assertTrue(lead1.getId().equals("L1"));
        assertTrue(lead2.getId().equals("L2"));
        assertTrue(lead3.getId().equals("L3"));

    }

    @Test
    void test2GetInfo(){
        Lead lead4= new Lead("name","03012030xxxx","vorname.nachname@dkb.de","DKB");
        Lead lead5= new Lead("name2","03012030yyyy","vorname2.nachname2@dkb.de","DKB");
        Lead lead6= new Lead("name3","03012030zzzz","vorname3.nachname3@dkb.de","DKB");


        assertTrue(lead4.getInfo().equals(lead4.getId() + ";name;03012030xxxx;vorname.nachname@dkb.de;DKB"));
        assertTrue(lead5.getInfo().equals(lead5.getId() + ";name2;03012030yyyy;vorname2.nachname2@dkb.de;DKB"));
        assertTrue(lead6.getInfo().equals(lead6.getId() + ";name3;03012030zzzz;vorname3.nachname3@dkb.de;DKB"));
    }

    @Test
    void test3ToString(){
        Lead lead6= new Lead("name","03012030xxxx","vorname.nachname@dkb.de","DKB");



        String testString = "Lead{" +
                    "Id='" + lead6.getId() + '\'' +
                    ", Name ='" + lead6.getName() /*"name"*/ + '\'' +
                    ", Phone Number='" + lead6.getPhoneNumber() /*"03012030xxxx" */ + '\'' +
                    ", Email Address='" + lead6.getEmail()/*"vorname.nachname@dkb.de"*/ + '\'' +
                    ", Company Name='" + lead6.getCompanyName() /*"DKB"*/ + '\'' +
                    '}';

        assertTrue(lead6.toString().equals(testString));
    }

}