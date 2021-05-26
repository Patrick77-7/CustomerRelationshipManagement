package main.java;

public class Contact extends CRMObject{

    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    public Contact(Lead lead){
        super("C");
        this.name = lead.getName();
        this.email = lead.getEmail();
        this.companyName = lead.getCompanyName();
        this.phoneNumber = lead.getPhoneNumber();
    }

    public Contact(){
        super("C");
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
