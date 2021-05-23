package main.java;

public class Contact {

    private String contactId;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    private static Integer idCounterC = 1;

    public Contact(Lead lead){

        this.name = lead.getName();
        this.email = lead.getEmail();
        this.companyName = lead.getCompanyName();
        this.phoneNumber = lead.getPhoneNumber();
        setContactId();
    }

    public static Integer createID() {
        return idCounterC++;
    }

    public void setContactId() {
        Integer newId = createID();
        this.contactId = "C " + newId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
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

    public String getContactId() {
        return contactId;
    }

}
