package bank.domain;

import java.util.*;


public class Account {
	long accountnumber;
	Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
	Customer customer;
	private IInterestStrategy interestStrategy;
	private String accountType;

	
	public Account (long accountnr){
		this.accountnumber = accountnr;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public double getBalance() {
		double balance=0;
		for (AccountEntry entry : entryList) {
			balance+=entry.getAmount();
		}
		return balance;
	}
	public void deposit(double amount){
		AccountEntry entry = new AccountEntry(new Date(), amount, "deposit", "", "");
		entryList.add(entry);
	}
	public void withdraw(double amount){
		AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "", "");
		entryList.add(entry);	
	}

	private void addEntry(AccountEntry entry){
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description){
		AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(new Date(), amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		entryList.add(fromEntry);	
		toAccount.addEntry(toEntry);

	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public void setInterestStrategy(IInterestStrategy interestStrategy) {
		this.interestStrategy = interestStrategy;
	}
	
	public void addInterest(){
		System.out.println("AddInterest on "+accountType+" account with account number "+accountnumber);
		System.out.println("Old balance = "+getBalance());
		double interest =interestStrategy.computeInterest(getBalance());
		AccountEntry entry = new AccountEntry(new Date(), interest, "interest", "", "");
		entryList.add(entry);
		System.out.println("New balance = "+getBalance());
	}


}
