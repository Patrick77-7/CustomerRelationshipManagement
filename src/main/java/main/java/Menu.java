package main.java;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public Lists leadList;

    public void showMenu() {

        System.out.println("\n");
        System.out.println("Welcome to CRM Application!");

        leadList = new Lists("Lead-List");

        boolean exit = false;

        while (!exit) {
            System.out.println("\n");
            System.out.println("What would you like to do?");
            String input = getStringInput();


            if (processRegionMatches("import list", input)) {
                try {
                    HashMap<String, Lead> z = leadList.importList();
                    leadList.setNewHashmap(z);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (processRegionMatches("New Lead", input)) {
                Lead lead = new Lead();
                lead.createNewLead();
                leadList.addToList(lead.getLeadId(), lead);
            } else if (processRegionMatches("Show Leads", input)) {
                System.out.println(leadList.showInfoAllLeads());
            } else if (processRegionMatches("convert", input)) {
                System.out.println("Type in ID of lead that is to be converted: ");
                String IdInput = getStringInput();
                Lead lead = leadList.getNewHashmap().get(IdInput);
                convertLeadToOpportunity(lead);
            } else if (processRegionMatches("Lookup Lead Id", input)) {
                System.out.println("Type in ID ");
                String IdInput = getStringInput();
                System.out.println(leadList.showInfo(IdInput));
            } else if (processRegionMatches("exit", input)) {
                exit = true;
                leadList.exportList();
            } else {
                System.out.println("Input unknown");
            }
        }

    }


    public Opportunity convertLeadToOpportunity(Lead lead) {
        Contact x = new Contact(lead); // needs to be added to Contact-List of an account?
        Products y = null;
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
        Opportunity opportunity = new Opportunity(x, y, amountOfProducts); // needs to be added to an Opportunity-List of an Account?
        leadList.removeFromList(lead.getLeadId());
        return opportunity;
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
