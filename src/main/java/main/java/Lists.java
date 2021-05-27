package main.java;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class Lists {
    private String name;
    HashMap<String, CRMObject> CRMHashMap = new HashMap<>();



    //Constructor

    public Lists() {
    }

    public Lists(String name) {
        this.name = name;
    }

    // Put into List
    public void addToList(String Id, CRMObject object) {
        this.CRMHashMap.put(Id, object);
    }

    // remove from List
    public void removeFromList(String Id) {
        this.CRMHashMap.remove(Id);
    }

    //Show Info LookUpLead

    public String showInfo(String Id) {
        String returnString = null;
        try {
            returnString = this.CRMHashMap.get(Id).getInfo();

        } catch (NullPointerException e) {
            System.out.println("Die Liste hat bisher keinen Inhalt");
        }
        return returnString;
    }

    // Show all List
    public String showAllInfo() {
        Set<String> keys = this.CRMHashMap.keySet();
        String allInfo = "";
        for (String key: keys) {
            allInfo = allInfo + showInfo(key) + "\n";
        }
        return allInfo;
    }

    //Getter and Setter

    public HashMap<String, CRMObject> getCRMHashMap() {
        return CRMHashMap;
    }

    public void setCRMHashMap(HashMap<String, CRMObject> CRMHashMap) {
        this.CRMHashMap = CRMHashMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean validID(String ID){
        boolean isValid = false;
        if(this.CRMHashMap.containsKey(ID)){
            isValid = true;
        }
        return isValid;
    }

}