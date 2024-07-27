package bank.dao;

import java.util.*;
import bank.domain.Account;

public class AccountDAO implements IAccountDAO {
	Map<Long,Account> accountlist = new HashMap<Long,Account>();

	public void saveAccount(Account account) {
		accountlist.put(account.getAccountnumber(), account); 
	}

	public void updateAccount(Account account) {
		accountlist.put(account.getAccountnumber(), account); 
	}

	public Account loadAccount(long accountnumber) {
		return accountlist.get(accountnumber);
	}

	public Collection<Account> getAccounts() {
		return accountlist.values();
	}

}
