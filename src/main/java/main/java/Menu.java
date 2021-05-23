package main.java;

import java.util.Scanner;

public class Menu {

    public void showMenu(){
        System.out.println("Welcome to CRM Application!");
        System.out.println("\n");
        System.out.println("What would you like to do?");
        System.out.println("\n");
        System.out.println("(1) Create new Lead.");
        System.out.println("\n");
        System.out.println("(2) Turn Lead into Opportunity.");
    }

    public Lead createNewLead(){
        System.out.println("Name of Lead:");
        String name = getStringInput();
        System.out.println("Phone number of Lead:");
        String phoneNumber = getStringInput();
        System.out.println("Email address of Lead:");
        String email = getStringInput();
        System.out.println("Company of Lead:");
        String companyName = getStringInput();
        return new Lead(name, phoneNumber, email, companyName);
    }

    public void addLeadToList(){

    }

    public void showLead(String leadId){

    }

    public void removeLead(){

    }

    public String getStringInput(){
        Scanner scan = new Scanner(System.in);
        String output = scan.nextLine();
        return output;
    }

}
