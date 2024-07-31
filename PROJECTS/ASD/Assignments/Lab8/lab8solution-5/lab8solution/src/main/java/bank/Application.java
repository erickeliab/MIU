package bank;

import java.lang.reflect.Proxy;
import java.util.Collection;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.IAccountService;
import bank.service.dto.AccountDTO;
import bank.service.dto.AccountEntryDTO;
import bank.service.dto.CustomerDTO;
import proxies.Timer;



public class Application {
	public static void main(String[] args) {
		IAccountService theAccountService = new AccountService();
		ClassLoader cl = IAccountService.class.getClassLoader();
		IAccountService accountService = (IAccountService) Proxy.newProxyInstance(cl, new Class[] { IAccountService.class }, new Timer(theAccountService));


		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");
		//use account 1;
		accountService.deposit(1263862, 240);
		accountService.deposit(1263862, 529);
		accountService.withdraw(1263862, 230);
		//use account 2;
		accountService.deposit(4253892, 12450);
		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		// show balances
		
		Collection<AccountDTO> accountlist = accountService.getAllAccounts();
		CustomerDTO customer = null;
		for (AccountDTO account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntryDTO entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}
	}

}


