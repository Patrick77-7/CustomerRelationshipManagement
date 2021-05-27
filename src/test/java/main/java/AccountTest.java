package main.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    public Lead l1;
    public Lead l2;
    public Lead l3;

    public Contact c1;
    public Contact c2;
    public Contact c3;

    public Opportunity o1;
    public Opportunity o2;
    public Opportunity o3;
    public Opportunity o4;
    public Opportunity o5;
    public Opportunity o6;

    @BeforeEach
    void init(){
        /*Initialize Contacts and Opportunities*/
        /*Opportunities of c1*/
        l1= new Lead("Person1","030120301111","person1@dkb.de","DKB");
        c1= new Contact(l1);
        o1= new Opportunity(c1,Products.BOX,1);
        o2= new Opportunity(c1,Products.FLATBED,2);
        /*Opportunities of c2*/
        l2= new Lead("Person2","030120302222","person2@dkb.de","DKB");
        c2= new Contact(l2);
        o3= new Opportunity(c2,Products.HYBRID,3);
        o4= new Opportunity(c2,Products.FLATBED,4);
        /*Opportunities of c3*/
        l3= new Lead("Person3","xxxxxxxxxxx3","person3@ironhack.de","ironhack");
        c3= new Contact(l3);
        o5= new Opportunity(c3,Products.BOX,5);
        o6= new Opportunity(c3,Products.HYBRID,6);
    }

    @Test
    void testInitAccount() {
        ArrayList<Contact> contactList1 = new ArrayList<>();
        ArrayList<Opportunity> oppList1 = new ArrayList<>();
        ArrayList<Contact> contactList2 = new ArrayList<>();
        ArrayList<Opportunity> oppList2 = new ArrayList<>();

        contactList1.add(c1);
        contactList1.add(c2);
        oppList1.add(o1);
        oppList1.add(o2);
        oppList1.add(o3);
        oppList1.add(o4);

        contactList2.add(c3);
        oppList2.add(o5);
        oppList2.add(o6);

        Account a1 = new Account(Industry.OTHER,3000,"Berlin","Germany",contactList1,oppList1);
        Account a2 = new Account(Industry.MANUFACTURING,100,"New York","USA",contactList2,oppList2);

        assertEquals(2,a1.getContactList().size());
        assertEquals("C1",a1.getContactList().get(0).getId());
        assertEquals("C2",a1.getContactList().get(1).getId());
        assertEquals(1,a2.getContactList().size());
        assertEquals("C3",a2.getContactList().get(0).getId());

        Account a3 = new Account();
        assertEquals("A3",a3.getId());
    }
}