import java.util.*;
public class Customer {
    private String customerID;
    private String pin;
    private String name;
    private List<Account> accounts;
    private List<Card> cards;

    public Customer(String customerID, String pin, String name, List<Account> accounts, List<Card> cards) {
        this.customerID = customerID;
        this.pin = pin;
        this.name = name;
        this.accounts = accounts;
        this.cards = cards;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getPin() {
        return pin;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Card> getCards() {
        return cards;
    }   
}














