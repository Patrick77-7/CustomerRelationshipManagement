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

        Opportunity o4 = new Opportunity(c2,Products.BOX,1);
        Opportunity o5 = new Opportunity(c2,Products.BOX,2);
        Opportunity o6 = new Opportunity(c2,Products.BOX,3);


        Lists listsOpportunities = new Lists("OpportunityList");
        listsOpportunities.addToList(o1.getId(),o1);
        listsOpportunities.addToList(o2.getId(),o2);
        listsOpportunities.addToList(o3.getId(),o3);
        listsOpportunities.addToList(o4.getId(),o4);
        listsOpportunities.addToList(o5.getId(),o5);
        listsOpportunities.addToList(o6.getId(),o6);

        System.out.println(listsOpportunities.showAllInfo());
        listsOpportunities.removeFromList(o1.getId());
        System.out.println(listsOpportunities.showAllInfo());

        //Opportunity opp1 = new Opportunity()

    }

    @Test
    void testShowAllInfoWithoutContent(){
        Lists lists1 = new Lists("List1");

        lists1.showAllInfo();
    }

    @Test
    void testShowInfoWithoutContent() {
        Lists lists1 = new Lists("List1");

        lists1.showInfo("L1");
    }
}