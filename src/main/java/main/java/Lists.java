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

    //    remove from List
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
    // export List

//    public void exportList() {
//        FileWriter x;
//        try {
//            x = new FileWriter(this.getName());
//            Integer lastId = this.CRMHashMap.size() + 1;
//            for (int i = 1; i < lastId; i++) {
//                x.write(this.CRMHashMap.get("L " + i).getInfo() + "\n");
//            }
////            x.write("\n" + "This list contains " + (lastId-1) + " leads");
//            x.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    // import list

//    public HashMap<String, Lead> importList() throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader(this.getName()));
//        String line = null;
//        HashMap<String, Lead> map = new HashMap<>();
//        while ((line = br.readLine()).contains("L")) {
//            String str[] = line.split(";");
//            for (int i = 0; i < str.length; i++) {
//                map.put(str[0], new Lead(str[0], str[1], str[2], str[3], str[4]));
//            }
//        }
//        return map;
//    }


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
        //Gibt True wenn ID als ID vorhanden ist
        //Gibt False wenn ID nicht als ID vorhanden ist
        return true;
    }

}