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

        System.out.println("\n");
        System.out.println("Welcome to CRM Application!");

        leadList = new Lists("Lead-List");
        contactList = new Lists("Contact-List");
        opportunityList = new Lists("Opportunity-List");
        accountList = new Lists("Account-List");


        boolean exit = false;

        while (!exit) {
            System.out.println("\n");
            System.out.println("What would you like to do?");
            String input = getStringInput();

    // ggf. switch draus machen
            if (processRegionMatches("New Lead", input)) {
                Lead lead = new Lead();
                lead.createNewLead();
                leadList.addToList(lead.getId(), lead);
            } else if (processRegionMatches("Show Leads", input)) {
                System.out.println(leadList.showAllInfo());
            } else if (processRegionMatches("convert", input)) {
                System.out.println("Type in ID of lead that is to be converted: ");
                String IdInput = getStringInput();
                Lead l1= (Lead)leadList.CRMHashMap.get(IdInput);
                convertLeadToOpportunity(l1);
            } else if (processRegionMatches("Lookup Lead Id", input)) {
                System.out.println("Type in ID ");
                String IdInput = getStringInput();
                System.out.println(leadList.showInfo(IdInput));
            }else if(processRegionMatches("close-lost", input)){
                System.out.println("Type in the Opportunity ID ");
                String IDInput = getStringInput();
                Opportunity o1 = (Opportunity)opportunityList.CRMHashMap.get(IDInput);
                o1.closeOpportunityStatus(Status.CLOSED_LOST);
            }else if(processRegionMatches("close-won", input)){
                System.out.println("Type in the Opportunity ID ");
                String IDInput = getStringInput();
                Opportunity o1 = (Opportunity)opportunityList.CRMHashMap.get(IDInput);
                o1.closeOpportunityStatus(Status.CLOSED_WON);
            }
            else if (processRegionMatches("exit", input)) {
                exit = true;
//                leadList.exportList();
            } else {
                System.out.println("Input unknown");
            }
        }

    }


    public void convertLeadToOpportunity(Lead lead) {
        Contact x = new Contact(lead); // needs to be added to Contact-List of an account?
        Products y = null;
        leadList.removeFromList(lead.getId());
        contactList.addToList(x.getId(),x);
        boolean inputRequiredProduct = false;
        while (inputRequiredProduct == !true) {
            System.out.println("Please insert the Type of Product the Customer is interested in:");
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
                    System.out.println("Please Enter hybrid, flatbed or box");
            }
        }
        int amountOfProducts = 0;
        boolean inputRequiredAmmount = false;
        while (inputRequiredAmmount == !true) {
            System.out.println("How many instances does the Customer intends to buy:");
            try {
                amountOfProducts = Integer.parseInt(getStringInput());
                inputRequiredAmmount = true;

            } catch (InputMismatchException ime) {
                System.out.println("Please Enter a Number");
            }
        }
        Opportunity opportunity = new Opportunity(x, y, amountOfProducts);
        opportunityList.addToList(opportunity.getId(),opportunity);
        boolean inputRequiredAccount = false;
        while(inputRequiredAccount == !true){
            System.out.println("Do you want to create a new Account");
            String answer = getStringInput();
            switch (answer.toUpperCase(Locale.ROOT)){
                case "YES" :
                    createNewAccount(x, opportunity);
                    inputRequiredAccount =true;
                    break;
                case "NO":
                    System.out.println("Enter the Account ID to which you want to add the information");
                    String accountID = getStringInput();
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


    public void createNewAccount(Contact c1, Opportunity o1){
        System.out.println("Type in Industry: ");
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
        int employeeCount = Integer.parseInt(employeeInput);

        System.out.println("Type in city name: ");
        String cityInput = getStringInput();

        System.out.println("Type in country: ");
        String countryInput = getStringInput();

        ArrayList<Contact> contactListOfAccount = new ArrayList<>();  // ggf. austauschen mit Lists-Object
        ArrayList<Opportunity> opportunityListOfAccount = new ArrayList<>(); // ggf. austauschen mit Lists-Object

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

    public static boolean processRegionMatches(String src, String dest) {
        for (int i = src.length() - dest.length(); i >= 0; i--)
            if (src.regionMatches(true, i, dest, 0, dest.length()))
                return true;
        return false;
    }


}
