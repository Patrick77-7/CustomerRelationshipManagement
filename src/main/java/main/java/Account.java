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
public class Account {

    private Integer accountId;
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private ArrayList<Contact> contactList;
    private ArrayList<Opportunity> opportunityList;

}
