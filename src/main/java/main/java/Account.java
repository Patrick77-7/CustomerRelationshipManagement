package main.java;

import java.util.ArrayList;

/*
When a Lead is converted, the user will be prompted for the industry, number of employees, city, and country of the organization. An Account represents the company that is looking to buy a truck. Each Account should have a List of Contacts and a List of Opportunities. To recap, the Account should have the following properties:
id - a unique identifier
industry - an Enum with options PRODUCE, ECOMMERCE, MANUFACTURING, MEDICAL, OTHER
employeeCount - a number representing the number of employees in the company
city - a String
country - a String
contactList - a List of Contacts associated with this Account
opportunityList - a list of Opportunities associated with this Account

 */
public class Account extends CRMObject {

    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private ArrayList<Contact> contactList;
    private ArrayList<Opportunity> opportunityList;

    public Account (String accountID, Industry industry, int employeeCount, String city, String country, ArrayList<Contact> contactList, ArrayList<Opportunity> opportunityList) {
        super("A", accountID);
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.contactList = contactList;
        this.opportunityList = opportunityList;
    }

    public Account (Industry industry, int employeeCount, String city, String country, ArrayList<Contact> contactList, ArrayList<Opportunity> opportunityList) {
        super("A");
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.contactList = contactList;
        this.opportunityList = opportunityList;
    }
    public Account(){
        super("A");
    }


    //Create Ongoing ID
    private static Integer idCounter = 1;

    public Integer createID() {
        return idCounter++;
    }

    // getter + setter

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }

    public ArrayList<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public void setOpportunityList(ArrayList<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }
}
