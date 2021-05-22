package main.java;

public class Opportunity {
    private String id;
    private Integer quantity;
    private Contact decisionMaker;
    private Status sold;
    private Products Truck;

    public Opportunity(Integer quantity, Contact decisionMaker, Status sold, Products truck) {
        setId();
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.sold = sold;
        this.Truck = truck;
    }

    private static Integer idCounterO = 0;

    public static Integer createID() {
        return idCounterO++;
    }

    public void setId() {
        Integer newId = createID();
        this.id = "C " + newId;
    }
}
