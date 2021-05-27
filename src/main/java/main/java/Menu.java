package main.java;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Menu {

    public Lists leadList;
    public Lists contactList;
    public Lists opportunityList;
    public Lists accountList;

    public void showMenu() {

        showTitle(" Welcome to CRM Application! ");

        leadList = new Lists("Lead-List");
        contactList = new Lists("Contact-List");
        opportunityList = new Lists("Opportunity-List");
        accountList = new Lists("Account-List");


        boolean exit = false;

        while (!exit) {
            showMenuOptions();
            String input = getStringInput();

            if (processRegionMatches("New Lead", input)) {
                Lead lead = new Lead();
                lead.createNewLead();
                leadList.addToList(lead.getId(), lead);
            } else if (processRegionMatches("Show Leads", input)) {
                System.out.println(leadList.showAllInfo());
            } else if (processRegionMatches("convert", input)) {
                convertLeadToOpportunity();
            } else if (processRegionMatches("Lookup Lead Id", input)) {
                lookUpLeadId();
            } else if(processRegionMatches("close-lost", input)){
                changeOpStatusToCloseLost();
            } else if(processRegionMatches("close-won", input)){
                changeOpStatusToCloseWon();
            } else if (processRegionMatches("exit", input)) {
                exit = true;
            } else {
                System.out.println("Input unknown");
            }
        }

    }


    public void convertLeadToOpportunity() {
        System.out.println("Type in ID of lead that is to be converted: ");
        String IdInput = getStringInput();
        while (!leadList.validID(IdInput)) {
            System.out.println("ID not found! Type in existing Lead ID ");
            IdInput = getStringInput();
        }
        Lead l1= (Lead)leadList.CRMHashMap.get(IdInput);

        Contact x = new Contact(l1); // needs to be added to Contact-List of an account?
        Products y = null;
        leadList.removeFromList(l1.getId());
        contactList.addToList(x.getId(),x);
        boolean inputRequiredProduct = false;
        while (!inputRequiredProduct) {
            System.out.println("Please insert the Type of Product the Customer is interested in: hybrid, flatbed OR box");
            String s = getStringInput();

            switch (s) {
                case "hybrid":
                    y = Products.HYBRID;
                    inputRequiredProduct = true;
                    break;
                case "flatbed":
                    y = Products.FLATBED;
                    inputRequiredProduct = true;
                    break;
                case "box":
                    y = Products.BOX;
                    inputRequiredProduct = true;
                    break;
                default:
                    System.out.println("Please Enter hybrid, flatbed OR box");
            }
        }
        int amountOfProducts = 0;

        boolean inputRequiredAmount = false;
        while (!inputRequiredAmount) {
            System.out.println("How many instances does the Customer intends to buy:");
            String instanceNumber = getStringInput();
            while (!isNumeric(instanceNumber)) {
                System.out.println("Please Enter a Full Number");
                instanceNumber = getStringInput();
            }
            amountOfProducts = Integer.parseInt(instanceNumber);
            inputRequiredAmount = true;
        }
        Opportunity opportunity = new Opportunity(x, y, amountOfProducts);
        opportunityList.addToList(opportunity.getId(),opportunity);
        boolean inputRequiredAccount = false;
        while(!inputRequiredAccount){
            System.out.println("Do you want to create a new Account");
            String answer = getStringInput();
            switch (answer.toUpperCase(Locale.ROOT)){
                case "YES" :
                    createNewAccount(x, opportunity);
                    inputRequiredAccount =true;
                    break;
                case "NO":
                    System.out.println("Enter the Account ID to which you want to add the information"); // noch mal testen!
                    String accountID = getStringInput();
                    while (!accountList.validID(accountID)){
                        System.out.println("ID not found! Type in existing Account ID ");
                        accountID = getStringInput();
                    }
                    Account a1 = (Account) accountList.CRMHashMap.get(accountID);
                    a1.getContactList().add(x);
                    a1.getOpportunityList().add(opportunity);
                    inputRequiredAccount =true;
                    break;
                default:
                    System.out.println("Please enter Yes or No!");
            }
        }
    }

    public void lookUpLeadId(){
        System.out.println("Type in Lead ID ");
        String IdInput = getStringInput();
        while (!leadList.validID(IdInput)) {
            System.out.println("ID not found! Type in existing Lead ID ");
            IdInput = getStringInput();
        }
        System.out.println(leadList.showInfo(IdInput));
    }

    public void changeOpStatusToCloseLost(){
        System.out.println("Type in the Opportunity ID ");
        String IDInput = getStringInput();
        while (!opportunityList.validID(IDInput)){
            System.out.println("ID not found! Type in existing Opportunity ID ");
            IDInput = getStringInput();
        }
        Opportunity o1 = (Opportunity)opportunityList.CRMHashMap.get(IDInput);
        o1.closeOpportunityStatus(Status.CLOSED_LOST);
    }

    public void changeOpStatusToCloseWon(){
        System.out.println("Type in the Opportunity ID ");
        String IDInput = getStringInput();
        while (!opportunityList.validID(IDInput)){
            System.out.println("ID not found! Type in existing Opportunity ID ");
            IDInput = getStringInput();
        }
        Opportunity o1 = (Opportunity)opportunityList.CRMHashMap.get(IDInput);
        o1.closeOpportunityStatus(Status.CLOSED_WON);
    }


    public void createNewAccount(Contact c1, Opportunity o1){
        System.out.println("Choose Industry by Number: ");
        System.out.println("1 - PRODUCE ");
        System.out.println("2 - ECOMMERCE ");
        System.out.println("3 - MANUFACTURING ");
        System.out.println("4 - MEDICAL ");
        System.out.println("Any key for OTHER");

        String industryInput = getStringInput();
        Industry y = null;
        switch(industryInput){
            case "1":
                y = Industry.PRODUCE;
                break;
            case "2":
                y = Industry.ECOMMERCE;
                break;
            case "3":
                y = Industry.MANUFACTURING;
                break;
            case "4":
                y = Industry.MEDICAL;
                break;
            default:
                y = Industry.OTHER;
                break;
        }

        System.out.println("Type in number of Employees: ");
        String employeeInput = getStringInput();
        while (!isNumeric(employeeInput)) {
            System.out.println("Please Enter a Full Number ");
            employeeInput = getStringInput();
        }
        int employeeCount = Integer.parseInt(employeeInput);

        System.out.println("Type in city name: ");
        String cityInput = getStringInput();

        System.out.println("Type in country: ");
        String countryInput = getStringInput();

        ArrayList<Contact> contactListOfAccount = new ArrayList<>();
        ArrayList<Opportunity> opportunityListOfAccount = new ArrayList<>();

        opportunityListOfAccount.add(o1);
        contactListOfAccount.add(c1);

        Account x = new Account(y, employeeCount, cityInput, countryInput, contactListOfAccount, opportunityListOfAccount);
        accountList.addToList(x.getId(),x);
    }


    public static String getStringInput() {
        Scanner scan = new Scanner(System.in);
        String output = scan.nextLine();
        return output;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
//            double d = Double.parseDouble(strNum);
            Integer i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean processRegionMatches(String src, String dest) {
        for (int i = src.length() - dest.length(); i >= 0; i--)
            if (src.regionMatches(true, i, dest, 0, dest.length()))
                return true;
        return false;
    }

    public void showTitle(String title) {
        //show title in cool format
        final int TITLEWIDTH = 61; //default length of 61
        int titleLength = title.length();

        int repeat1 = ((TITLEWIDTH - titleLength) / 2);
        int repeat2 = (TITLEWIDTH - titleLength) - repeat1;
        System.out.println("#############################################################");
        System.out.println("#".repeat(repeat1) + title + "#".repeat(repeat2));
        System.out.println("#############################################################");
    }

    public void showMenuOptions() {
        System.out.println("\n");
        System.out.println("What would you like to do?");
        System.out.println("\n");
        System.out.println("[new lead]          creates a new Lead");
        System.out.println("[show leads]        shows full List of Leads");
        System.out.println("[lookup lead id]    looks up any Lead by Id");
        System.out.println("[convert]      converts Lead to Opportunity");
        System.out.println("[close-lost]        changes the Status of an Opportunity to lost");
        System.out.println("[close-won]         changes the Status of an Opportunity to won");
        System.out.println("[exit]              exits the Application");



    }


}
