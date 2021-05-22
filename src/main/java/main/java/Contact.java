package main.java;


public class Contact{
    String name;
    String eMail;
    String companyName;
    String phoneNumber;
    String id;

    //Remove Object existiert in Java nicht ? Lösung in Menu Class add to List Oppertunity remove from List Leads

    //Setter & Getter
    private static Integer idCounterC = 0;

    public Contact(Lead lead){

        this.name = lead.getName();
        this.eMail = lead.geteMail();
        this.companyName = lead.getCompanyName();
        this.phoneNumber = lead.getPhoneNumber();
        setId();
    }

    public static Integer createID() {
        return idCounterC++;
    }

    public void setId() {
        Integer newId = createID();
        this.id = "C " + newId;
    }

    public void setId(String Id) {
        this.id = Id;
    }

    public String getName() {
        return name;
    }

    public String geteMail() {
        return eMail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getId() {
        return id;
    }
}
