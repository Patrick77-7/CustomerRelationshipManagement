package main.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpportunityTest {


    Lead lead1 = new Lead("name","03012030xxxx","vorname.nachname@dkb.de","DKB");
    Lead lead2 = new Lead("name2","03012030yyyy","vorname2.nachname2@dkb.de","DKB");

    Contact contact1 = new Contact(lead1);
    Contact contact2 = new Contact(lead2);


    @Test //Create Opportunity and Test CreateId
    void createNewOpportunity() {

        Opportunity opportunity1 = new Opportunity(contact1, Products.BOX, 120);
        Opportunity opportunity2 = new Opportunity(contact2, Products.HYBRID, 240);

        assertTrue(opportunity1.getId().equals("O 1"));
        assertTrue(opportunity2.getId().equals("O 2"));

    }

    @Test //
    void setOpportunityId() {
        Opportunity opportunity1 = new Opportunity(contact1, Products.BOX, 120);

//        opportunity1.setId("2");
//        assertTrue(opportunity1.getId().equals("O 2"));
//        opportunity1.setId("3");
//        assertTrue(opportunity1.getId().equals("O 3"));


    }

}