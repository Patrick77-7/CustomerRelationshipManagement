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
public class Opportunity extends CRMObject{

    private Contact decisionMaker;
    private Products product;
    private Integer quantity;
    private Status status;


    public Opportunity(Contact decisionMaker, Products product, Integer quantity) {
        super("O");
        this.decisionMaker = decisionMaker;
        this.product = product;
        this.quantity = quantity;
        this.status = Status.OPEN;
    }
    public Opportunity(){
        super("O");
    }

    //Getter and Setter

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
