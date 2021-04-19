import java.util.*;

class ATM {
    public static void main(String[] args) {
        //create new customer with new accounts and new cards and map cardID to a PIN-Customer Pair.
        Map<String, Pair> customerInfo = new HashMap<>();
        List<Account> newAccount1 = new ArrayList<>();
        newAccount1.add(new Account("Checking"));
        newAccount1.add(new Account("Saving"));
        List<Card> newCard1 = new ArrayList<>();
        newCard1.add(new Card("Debit", "111111", "1"));
        newCard1.add(new Card("Credit", "111112", "1"));
        customerInfo.put("111111", new Pair("123456", new Customer("1", "123456", "Amy", newAccount1, newCard1)));
        customerInfo.put("111112", new Pair("123456", new Customer("1", "123456", "Amy", newAccount1, newCard1)));

       
        // read card and PIN number.
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter card number:");
        String cardNumber = myObj.nextLine();

        System.out.println("\nPlease enter PIN:");
        String cardPIN = myObj.nextLine();

        // cheack if card number and PIN match an entry in customerInfo
        if (!customerInfo.containsKey(cardNumber) || !customerInfo.get(cardNumber).pin.equals(cardPIN)) {
            myObj.close();
            throw new IllegalArgumentException("Invalid Card NUmber or PIN.");
        }

        Customer curCustomer = customerInfo.get(cardNumber).customer;
        List<Account> curAccounts = curCustomer.getAccounts();
        System.out.println("\nHi " + curCustomer.getName() + " Welcome!");
        ATM atm = new ATM();
        atm.makeTransaction(curAccounts, myObj);

        myObj.close();
        System.out.println("\nThank you for choosing ABC Bank. Wish you have a great day. Bye!\n");
    }


    public void makeTransaction(List<Account> curAccounts, Scanner myObj) {
        // select an account and check if the account exists
        System.out.println("\nPlease select an account:");
        for (Account account : curAccounts) {
            System.out.println(account.getType()); 
        }
        String accountType = myObj.nextLine();

        boolean existAccount = false;
        Account account = new Account();
        for (Account curAccount : curAccounts) {
            if (curAccount.getType().equals(accountType)) {
                account = curAccount;
                existAccount = true;
                break;
            }
        }

        if (existAccount == false) {
            System.out.println("Invalid account name!");   
        } 
        // See Balance/Deposit/Withdraw
        else {
            System.out.println("\nPlease select a service (type 1, 2, or 3):\n 1. See Balance,\n 2. Make a Deposite,\n 3. Withdraw Money.\n"); 
            String operation = myObj.nextLine();
            
            if (operation.equals("1"))
                System.out.println("\nYour current balance is " + account.getBalance() + " dollars.");
            else if (operation.equals("2")) {
                System.out.println("\nHow much you want to deposite?");
                float deposite = myObj.nextFloat();
                float newBalance = account.makeDeposite(deposite);
                System.out.println("\nYour current balance is " + newBalance + " dollars.");
            }
            else if (operation.equals("3")) {
                System.out.println("\nHow much you want to withdraw?");
                float withdraw = myObj.nextFloat();
                float newBalance = account.makeWithdraw(withdraw);
                System.out.println("\nYour current balance is " + newBalance + " dollars.");
            }
            else {
                System.out.println("Invalid Service.");
            }
        }

        // call transaction again if user wish to continue.
        System.out.println("\nDo you want to continue? Please type 1 for Yes, 2 for No");
        myObj = new Scanner(System.in);
        String checkContinue = myObj.nextLine();
        if (checkContinue.equals("1"))
            makeTransaction(curAccounts, myObj);
    }
}

class Pair {
    String pin;
    Customer customer;
    public Pair(String pin, Customer customer) {
        this.pin = pin;
        this.customer = customer;
    }
}
