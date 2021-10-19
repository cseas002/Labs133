public class BankAccount {
    private String id;
    private double balance;
    private int transactions = 0;

    BankAccount(String id, double balance)
    {
        this.id = id;
        this.balance = balance;
    }
    public double getBalance()
    {
        return balance;
    }
    public String getID()
    {
        return id;
    }
    public int getTransactions()
    {
        return transactions;
    }

    public void deposit(double amount)
    {
        if (amount >= 0 && amount <= 500) {
            balance += amount;
            transactions++;
        }
        else
            StdOut.println("Can't deposit that money");
    }

    public void withdraw(double amount)
    {
        if (amount >= 0 && amount <= balance)
        {
            balance -= amount;
            transactions ++;
        }
        else
            StdOut.println("Can't withdraw this amount of money");
    }

    public boolean transactionFee(double fee)
    {
        for (int i = 1; i <= transactions; i++)
            balance -= i * fee;

        if (balance < 0) {
            balance = 0;
            return false;
        }
        return true;
    }

    public void transfer(BankAccount other, double money)
    {
        if (this.balance + money < 5 || other.balance < 5)
            return ;
        if (money > other.balance - 5)
            money = other.getBalance();
        other.withdraw(money + 5);
        this.deposit(money - 5);
    }

    public String toString()
    {
        return id + ", $" + balance;
    }

}
