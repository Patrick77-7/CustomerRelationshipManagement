package main.java;

public abstract class CRMObject {
    private String id;

    public CRMObject(String classLetter) {
        setId(classLetter);
    }
    public CRMObject(String classLetter, String givenId) {
        setGivenID(givenId);
    }

//    Create ID method
    private static Integer idCounter = 1;

    public static Integer createID() {
        return idCounter++;
    }
//    Getter and Setter

    public String getId() {
        return id;
    }

    public void setGivenID(String givenId) {
        this.id = givenId;
    }

    public void setId(String classLetter) {
        Integer newID = createID();
        this.id = classLetter + newID;
    }

    public String getInfo(){
        return null;
    }
}
