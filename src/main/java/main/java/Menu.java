package main.java;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    Lists leadList;

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
                // ...
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


    public static Opportunity convertLeadToOpportunity(Lead lead) {
        Contact x = new Contact(lead);
        Products y = null;
        boolean inputRequiredProduct = false;
        while (inputRequiredProduct = !true) {
            System.out.println("Please Insert the Type of Product the Customer is Interesetd in:");
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
        int ammountOfProducts = 0;
        boolean inputRequiredAmmount = false;
        while (inputRequiredAmmount = !true) {
            System.out.println("How many instances does the Customer intents to buy:");
            try {
                ammountOfProducts = Integer.parseInt(getStringInput());
                inputRequiredAmmount = true;

            } catch (InputMismatchException ime) {
                System.out.println("Please Enter a Number");
            }
        }

        Opportunity opportunity = new Opportunity(x, y, ammountOfProducts);
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
