public class SavingsAccount extends Account {

    private String accountID;

    private double balance;

    private double interestRate;

    SavingsAccount(String accID, double interestRate, double startBalance){
        accountID = accID;
        balance = startBalance;
        this.interestRate = interestRate;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String getAccountID() {
        return accountID;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double computeUpdatedBalanceSum() {
        return balance + (interestRate * balance);
    }
}
