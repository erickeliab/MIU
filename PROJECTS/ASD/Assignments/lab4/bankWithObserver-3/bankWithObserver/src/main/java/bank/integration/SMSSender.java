package bank.integration;

import bank.domain.Account;
import bank.service.IAccountService;

public class SMSSender extends Observer {

	public SMSSender(IAccountService accountService) {
		super(accountService);
	}

	public void sendSMS(String message) {
		System.out.println("SMS Sender: " + message);
	}

	public void update() {
		Account account = accountService.getLastCreatedOrAccessedAccount();
		String smsstring = "Account " + account.getAccountnumber() + " is changed, new balance = "
				+ account.getBalance();
		sendSMS(smsstring);

	}
}
