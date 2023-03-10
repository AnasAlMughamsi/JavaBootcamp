public class Account {

    private String id;
    private String name;
    private double balance = 0;

    public Account() {

    }
    public Account(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public double credit(double amount) {
        if(balance == 0) {
            System.out.println("Account has no balance");
        }
        return balance += amount;
    }
    // withdraw
    public double debit(double amount) {
        if(balance == 0) {
            System.out.println("Account has no balance");
        }
        return balance -= amount;
    }

    public double transferTo(Account account, double amount) {
        if(this.balance == 0) {
            System.out.println("Account has no balance!");
        }
        account.balance += amount;
        System.out.println("transfer amount: " + amount + " to " + account.getName());
        return this.balance -= amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
