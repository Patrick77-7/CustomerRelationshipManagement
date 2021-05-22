package main.java;

public class Lead {
    String name;
    String eMail;
    String companyName;
    String phoneNumber;
    String id;

    //Constructor

    public Lead(String name, String eMail, String companyName, String phoneNumber) {
        setName(name);
        seteMail(eMail);
        setCompanyName(companyName);
        setPhoneNumber(phoneNumber);
        setId();
    }

    public Lead(String name, String eMail, String companyName, String phoneNumber, String Id) {
        setName(name);
        seteMail(eMail);
        setCompanyName(companyName);
        setPhoneNumber(phoneNumber);
        setId(Id);
    }

    //Create Ongoing ID
    private static Integer idCounterL = 0;

    public static Integer createID() {
        return idCounterL++;
    }

    // Setter and Getter

    public String getInfo() {
        return this.getName() + " " + this.geteMail() + " " + this.getCompanyName() + " " + this.getPhoneNumber() + " " + this.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return this.id;
    }

    public void setId() {
        Integer newId = createID();
        this.id = "L " + newId;
    }

    public void setId(String Id) {
        this.id = Id;
    }
}
