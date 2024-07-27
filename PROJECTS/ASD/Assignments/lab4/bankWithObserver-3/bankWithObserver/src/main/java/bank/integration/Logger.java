package bank.integration;

import java.util.Date;

import bank.domain.Account;
import bank.service.IAccountService;

public class Logger extends Observer {

	public Logger(IAccountService accountService) {
		super(accountService);
	}

	public void log(String logstring) {
		System.out.println("Logging: --------" + new Date() + " -- " + logstring);
	}

	public void update() {
		Account account = accountService.getLastCreatedOrAccessedAccount();
		String logstring = "Account "+account.getAccountnumber()+" is changed, new balance = "+account.getBalance();
		log(logstring);

	}

}
