package main.java;

import java.io.*;
import java.util.HashMap;

public class Lists {
    private String name;
    HashMap<String, Lead> leadHashMap = new HashMap<>();
    HashMap<String, Opportunity> opportunityHashMap = new HashMap<>();
    HashMap<String, Contact> contactHashMap = new HashMap<>();


    //Constructor

    public Lists() {
    }

    public Lists(String name) {
        this.name = name;
    }

    // Put into List
    public void addToList(String Id, Lead Lead) {
        this.leadHashMap.put(Id, Lead);
    }

    //    remove from List
    public void removeFromList(String Id) {
        this.leadHashMap.remove(Id);
    }

    //Show Info LookUpLead
    public String showInfo(String Id) {
        return this.leadHashMap.get(Id).getInfo();
    }

    // Show all List

    public String showInfoAllLeads() {
        Integer lastId = this.leadHashMap.size() + 1;
        String allInfo = "";
        for (int i = 1; i < lastId; i++) {
            allInfo = allInfo + this.leadHashMap.get("L " + i).getInfo() + "\n";
        }
        return allInfo;
    }


    public String showInfoAllContacts() {
        Integer lastId = this.leadHashMap.size();
        String allInfo = "";
        for (int i = 0; i < lastId; i++) {
            allInfo = allInfo + this.leadHashMap.get("C " + i).getInfo() + "\n";
        }
        return allInfo;
    }

    public String showInfoAllOpportunity() {
        Integer lastId = this.leadHashMap.size();
        String allInfo = "";
        for (int i = 0; i < lastId; i++) {
            allInfo = allInfo + this.leadHashMap.get("O " + i).getInfo() + "\n";
        }
        return allInfo;
    }

    // export List

    public void exportList() {
        FileWriter x;
        try {
            x = new FileWriter(this.getName());
            Integer lastId = this.leadHashMap.size() + 1;
            for (int i = 1; i < lastId; i++) {
                x.write(this.leadHashMap.get("L " + i).getInfo() + "\n");
            }
//            x.write("\n" + "This list contains " + (lastId-1) + " leads");
            x.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // import list

    public HashMap<String, Lead> importList() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.getName()));
        String line = null;
        HashMap<String, Lead> map = new HashMap<>();
        while ((line = br.readLine()).contains("L")) {
            String str[] = line.split(";");
            for (int i = 0; i < str.length; i++) {
                map.put(str[0], new Lead(str[0], str[1], str[2], str[3], str[4]));
            }
        }
        return map;
    }


    //Getter and Setter

    public HashMap<String, Lead> getLeadHashMap() {
        return leadHashMap;
    }

    public void setLeadHashMap(HashMap<String, Lead> leadHashMap) {
        this.leadHashMap = leadHashMap;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}