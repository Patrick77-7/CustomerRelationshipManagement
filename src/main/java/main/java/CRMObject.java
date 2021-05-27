package main.java;

public abstract class CRMObject {
    protected String id;

    public CRMObject(String classLetter) {
        setId(classLetter);
    }
    public CRMObject(String classLetter, String givenId) {
        setGivenID(givenId);
    }

 //   Create ID method
    protected static Integer idCounter;

    public Integer createID(){
        return 0;
    };
  //  Getter and Setter

    public String getId() {
        return this.id;
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
