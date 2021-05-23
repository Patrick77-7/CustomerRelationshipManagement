package main.java;



public class Lead {
    private String leadId;
    private String name;
    private String phoneNumber; // <-- int oder String? Falls jemand sowas wie +49 eintippt? Maxi: String würde ich sagen!
    private String email;
    private String companyName;

    //Constructor

    public Lead(String name, String phoneNumber, String email, String companyName) {
        setName(name);
        setEmail(email);
        setCompanyName(companyName);
        setPhoneNumber(phoneNumber);
        setLeadId();
    }

    //Create Ongoing ID
    private static Integer idCounterL = 0;

    public static Integer createID() {
        return idCounterL++;
    }


    // setter + getter

    public String getInfo() {
        return this.getName() + " " + this.getEmail() + " " + this.getCompanyName() + " " + this.getPhoneNumber() + " " + this.getLeadId();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLeadId() {
        return leadId;
    }

    public void setLeadId(String leadId) {
        this.leadId = leadId;
    }

    public void setLeadId() {
        Integer newId = createID();
        this.leadId = "L " + newId;
    }


}
