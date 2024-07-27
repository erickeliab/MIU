package bank.integration;

import bank.domain.Account;
import bank.service.IAccountService;

public class EmailSender extends Observer {

	public EmailSender(IAccountService accountService) {
		super(accountService);
	}

	public void sendEmail(String message) {
		System.out.println("Email Sender: " + message);
	}

	public void update() {
		Account account = accountService.getLastCreatedOrAccessedAccount();
		String emailstring = "Account created: " + account.getAccountnumber() ;
		sendEmail(emailstring);
	}
}
