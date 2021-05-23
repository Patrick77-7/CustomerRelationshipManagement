package main.java;

import java.util.Scanner;

public class Menu {
    Lists leads = new Lists();


    public void showMenu(){
        System.out.println("\n");
        System.out.println("Welcome to CRM Application!");
        boolean exit = false;

        while(!exit) {
            System.out.println("\n");
            System.out.println("What would you like to do?");
            String input = getStringInput();

            if (processRegionMatches("New Lead", input)) {
                Lead lead = new Lead();
                lead.createNewLead();
                leads.addToList(lead.getLeadId(), lead);
            } else if (processRegionMatches("Show Leads", input)) {
                System.out.println(leads.showInfoAllLeads());
            } else if (processRegionMatches("convert", input)) {
                // ...
            } else if (processRegionMatches("Lookup Lead Id", input)) {
                System.out.println("Type in ID ");
                String IdInput = getStringInput();
                System.out.println(leads.showInfo(IdInput));
            } else if (processRegionMatches("exit", input)) {
                exit = true;
            } else {
                System.out.println("Input unknown");
            }
        }

        }




    public static String getStringInput(){
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
