package main.java;


public class Main {
    public static void main(String[] args) {

//        Menu m1 = new Menu();
//        m1.showMenu();
        Lead l1 = new Lead("Stebe", "ssseee", "sseeff","ss" );
        Contact c1 = new Contact(l1);
        Opportunity o1 = new Opportunity(c1, Products.FLATBED,12,Status.OPEN);

    }
}
