package main.java;

import java.util.HashMap;

public class OpportunityList extends MasterList {
    HashMap<String, Opportunity> opportunityMap = new HashMap<>();

    public OpportunityList(HashMap<String, Opportunity> opportunityMap) {
        this.opportunityMap = opportunityMap;
    }

    public OpportunityList() {
    }

    // Put into List
    public void addToList(String Id, Opportunity opportunity) {
        this.opportunityMap.put(Id, opportunity);
    }
    //Show Info LookUpLead
    public String showInfo(String Id) {
        return this.opportunityMap.get(Id).getInfo();
    }

    public String showInfoAllOpportunity() {
        Integer lastId = this.opportunityMap.size();
        String allInfo = "";
        for (int i = 0; i < lastId; i++) {
            allInfo = allInfo + this.opportunityMap.get("O " + i).getInfo() + "\n";
        }
        return allInfo;
    }

}
