package bank.service.dto;

import java.util.*;


public class AccountDTO {
	long accountnumber;
	Collection<AccountEntryDTO> entryList = new ArrayList<AccountEntryDTO>();
	CustomerDTO customer;
	double balance;

	
	public AccountDTO (long accountnr, double balance){
		this.accountnumber = accountnr;
		this.balance=balance;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public double getBalance() {		
		return balance;
	}

	public void addEntry(AccountEntryDTO entry){
		entryList.add(entry);
	}
	
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public Collection<AccountEntryDTO> getEntryList() {
		return entryList;
	}

}
