import java.util.ArrayList;

public class Employee {

    private String name;
    private ArrayList<Account> accounts;


    Employee(String name){
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account){
        this.accounts.add(account);
    }


    public double computeUpdatedBalanceSum(){
        double total = 0;
        for (Account account: accounts){
            total += account.computeUpdatedBalanceSum();
        }
        return total;
    }

}
