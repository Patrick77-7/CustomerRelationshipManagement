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

    protected static Integer idCounter = 1;

    @Override
    public Integer createID() {
        return idCounter++;
    }



    @Override
    public String getInfo() {
        return this.getId() + ";" + this.getName() + ";" + this.getPhoneNumber() + ";" + this.getEmail() + ";" + this.getCompanyName();
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
