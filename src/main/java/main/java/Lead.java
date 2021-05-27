package main.java;



public class Lead extends CRMObject {
    private String leadId;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    //Constructor

    public Lead(String name, String phoneNumber, String email, String companyName) {
        super("L");
        setName(name);
        setEmail(email);
        setCompanyName(companyName);
        setPhoneNumber(phoneNumber);
    }

    public Lead(String leadId, String name, String phoneNumber, String email, String companyName) {
        super("L", leadId);
        setName(name);
        setEmail(email);
        setCompanyName(companyName);
        setPhoneNumber(phoneNumber);
    }

    public Lead() {
        super("L");
    }



    // create new Lead

    public void createNewLead(){
        System.out.println("Name of Lead:");
        String name = Menu.getStringInput();
        setName(name);
        System.out.println("Phone number of Lead:");
        String phoneNumber = Menu.getStringInput();
        setPhoneNumber(phoneNumber);
        System.out.println("Email address of Lead:");
        String email = Menu.getStringInput();
        setEmail(email);
        System.out.println("Company of Lead:");
        String companyName = Menu.getStringInput();
        setCompanyName(companyName);
    }

    // setter + getter
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



    @Override
    public String toString() {
        return "Lead{" +
                "Id='" + leadId + '\'' +
                ", Name ='" + name + '\'' +
                ", Phone Number='" + phoneNumber + '\'' +
                ", Email Address='" + email + '\'' +
                ", Company Name='" + companyName + '\'' +
                '}';
    }
}
