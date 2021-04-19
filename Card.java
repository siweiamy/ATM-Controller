public class Card {
    private String type;
    private String cardID;
    private String customerID;

    public Card(String type, String cardID, String customerID) {
        this.type = type;
        this.cardID = cardID;
        this.customerID = customerID;
    }

    public String getType() {
        return type;
    }

    public String getCardID() {
        return cardID;
    }

    public String getCustomerID() {
        return customerID;
    }
    
}
