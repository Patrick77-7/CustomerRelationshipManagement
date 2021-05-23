package main.java;

import java.util.HashMap;

public class Lists {
    HashMap<String, Lead> newHashmap = new HashMap<>();

    //Constructor

    public Lists() {
    }

    // Put into List

    public void addToList(String Id, Lead Lead) {
        this.newHashmap.put(Id, Lead);
    }

    //Show Info LookUpLead
    public String showInfo(String Id) {
        return this.newHashmap.get(Id).getInfo();
    }

    // Show all List

    public String showInfoAllLeads() {
        Integer lastId = this.newHashmap.size();
        String allInfo = "";
        for (int i = 0; i < lastId; i++) {
            allInfo = allInfo + this.newHashmap.get("L " + i).getInfo() + "\n";
        }
        return allInfo;
    }
    public String showInfoAllContacts() {
        Integer lastId = this.newHashmap.size();
        String allInfo = "";
        for (int i = 0; i < lastId; i++) {
            allInfo = allInfo + this.newHashmap.get("C " + i).getInfo() + "\n";
        }
        return allInfo;
    }
    public String showInfoAllOpportunity() {
        Integer lastId = this.newHashmap.size();
        String allInfo = "";
        for (int i = 0; i < lastId; i++) {
            allInfo = allInfo + this.newHashmap.get("O " + i).getInfo() + "\n";
        }
        return allInfo;
    }

    //Getter and Setter

    public HashMap<String, Lead> getNewHashmap() {
        return newHashmap;
    }

    public void setNewHashmap(HashMap<String, Lead> newHashmap) {
        this.newHashmap = newHashmap;
    }
}