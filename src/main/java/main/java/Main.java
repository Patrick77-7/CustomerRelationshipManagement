package main.java;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String,Lead> allLeads = new HashMap<>();
        Lists leads = new Lists();
        Lists oppertunity = new Lists();

        Lead l1 = new Lead("Steven", "Steven@gmx.de","Steven Corp","+0011442266455");
        Lead l2 = new Lead("Steven", "Steven@gmx.de","Steven Corp","+0011442266455");
        Lead l3 = new Lead("Steven", "Steven@gmx.de","Steven Corp","+0011442266455");
        Lead l4 = new Lead("Steven", "Steven@gmx.de","Steven Corp","+0011442266455");

        allLeads.put("L 0",l1);
        allLeads.put(l2.getId(),l2);
        allLeads.put(l3.getId(),l3);
        allLeads.put(l4.getId(),l4);
//
//        System.out.println(allLeads.get("L 0").getName());
//        System.out.println(allLeads.get("L 1").getName());

        leads.addToList(l1.getId(),l1);
        leads.addToList(l2.getId(),l2);
        leads.addToList(l3.getId(),l3);
        leads.addToList(l4.getId(),l4);

//        System.out.println(leads.showInfo("L 1"));

//        System.out.println(leads.showInfoAllLeads());

        Contact c1 = new Contact(l1);

        System.out.println(c1.getId());
        System.out.println(l1.getName());




    }
}
