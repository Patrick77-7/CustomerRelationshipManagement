package main.java;

/*
When a Lead is converted, the user will be prompted for the product and the number of trucks for this Opportunity.
A new Opportunity should be created with the above information and with the new Contact as the decisionMaker for the Opportunity and a status of “OPEN”.
To recap, Opportunity should have the following properties:
id - a unique identifier
product - an Enum with options HYBRID, FLATBED, or BOX
quantity - the number of trucks being considered for purchase
decisionMaker - a Contact
status - an Enum with options OPEN, CLOSED_WON, CLOSED_LOST (these are common sales terms indicating an ongoing potential sale, a sale,
and an opportunity where a sale was not made and the sale is no longer a possibility)
 */
public class Opportunity {

    private String opportunityId;
    private Contact decisionMaker;
    private Products truck;
    private Integer quantity;
    private Status sold;

    public Opportunity(Contact decisionMaker, Products truck, Integer quantity, Status sold) {
        setOpportunityId();
        this.decisionMaker = decisionMaker;
        this.truck = truck;
        this.quantity = quantity;
        this.sold = sold;
    }

    private static Integer idCounterO = 1;

    public static Integer createID() {
        return idCounterO++;
    }

    public void setOpportunityId() {
        Integer newId = createID();
        this.opportunityId = "C " + newId;
    }

}
