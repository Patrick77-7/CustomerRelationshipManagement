package main.java;

import org.junit.jupiter.api.Test;

import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ListsTest {

    @Test
    void testShowAllInfo(){
        Lead lead1 = new Lead("Peter","1111","test@dkb.de","DKB");
        Lead lead2 = new Lead("Paul","1111","test@dkb.de","DKB");
        Lead lead3 = new Lead("Petra","4444","test2@dkb.de","DKB");

        Lists lists1 = new Lists("LeadList");
        lists1.addToList(lead1.getId(),lead1);
        lists1.addToList(lead2.getId(),lead2);
        lists1.addToList(lead3.getId(),lead3);

        System.out.println(lists1.showAllInfo());

        Contact c1 = new Contact(lead1);
        Contact c2= new Contact(lead2);
        Contact c3= new Contact(lead3);

        Lists listsContacts = new Lists("ContactList");
        listsContacts.addToList(c1.getId(),c1);
        listsContacts.addToList(c2.getId(),c2);
        listsContacts.addToList(c3.getId(),c3);

        System.out.println(listsContacts.showAllInfo());

        Opportunity o1 = new Opportunity(c1,Products.BOX,12);
        Opportunity o2 = new Opportunity(c1,Products.HYBRID,10);
        Opportunity o3 = new Opportunity(c1,Products.FLATBED,1);


        Lists listsOpportunities = new Lists("OpportunityList");
        listsOpportunities.addToList(o1.getId(),o1);
        listsOpportunities.addToList(o2.getId(),o2);
        listsOpportunities.addToList(o3.getId(),o3);

        System.out.println(listsOpportunities.showAllInfo());

        //Opportunity opp1 = new Opportunity()

    }
}