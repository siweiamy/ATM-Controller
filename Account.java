public class Account {
    private String type;
    private float balance = 0;

    public Account() {
    }

    public Account(String type) {
        this.type = type; 
    }

    public String getType() {
        return type;
    }

    public float getBalance() {
        return balance;
    }

    public float makeDeposite(float deposite) {
        balance += deposite;
        System.out.println("\nDeposite Succeed!");
        return balance;
    }

    public float makeWithdraw(float withdraw) {
        if (balance - withdraw < 0) {
            try {
                throw new Exception("\nNOT ENOUGH MONEY LEFT! Withdraw Failed!");
            } catch(Exception e) {
                System.out.println(e);
            }
        }
        else {
            balance -= withdraw;
            System.out.println("Withdraw Succedd!");
        }
        return balance;
    }

    
}
