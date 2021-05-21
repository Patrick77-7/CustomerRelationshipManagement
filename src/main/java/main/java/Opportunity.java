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
public class Opportunity extends Leads { //<-- wenn ein Lead umgewandelt wird, werden die Probs (Name, Tel,etc) übernommen. Die können wir doch so nutzen

    private int opportuniyId;
    private Products product;
    private int quantity;
    private Contact contact; //decisionMaker
    private Status status;
}
