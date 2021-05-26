package main.java;

import java.io.*;
import java.util.HashMap;

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

    //    remove from List
    public void removeFromList(String Id) {
        this.CRMHashMap.remove(Id);
    }

    //Show Info LookUpLead
    public String showInfo(String Id) {
        return this.CRMHashMap.get(Id).getInfo();
    }

    // Show all List

    public String showAllLeads(String classLetter) {
        Integer lastId = this.CRMHashMap.size() + 1;
        String allInfo = "";
        for (int i = 1; i < lastId; i++) {
            allInfo = allInfo + this.CRMHashMap.get(classLetter + " " + i).getInfo() + "\n";
        }
        return allInfo;

        // get all Keys and loop throw keys
    }
    // export List

    public void exportList() {
        FileWriter x;
        try {
            x = new FileWriter(this.getName());
            Integer lastId = this.CRMHashMap.size() + 1;
            for (int i = 1; i < lastId; i++) {
                x.write(this.CRMHashMap.get("L " + i).getInfo() + "\n");
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

}