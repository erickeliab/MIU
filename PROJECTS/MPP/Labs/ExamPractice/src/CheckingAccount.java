public class CheckingAccount extends Account {

    private String accountID;
    private double balance;

    private double monthlyFee;

    CheckingAccount(String accID, double fee, double startBalance){
        accountID = accID;
        balance = startBalance;
        monthlyFee = fee;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }
    public double getMonthlyFee() {
        return monthlyFee;
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
        return balance - monthlyFee;
    }


}
