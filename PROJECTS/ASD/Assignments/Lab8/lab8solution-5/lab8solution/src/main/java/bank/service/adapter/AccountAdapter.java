package bank.service.adapter;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.service.dto.AccountDTO;
import bank.service.dto.AccountEntryDTO;
import bank.service.dto.CustomerDTO;

public class AccountAdapter {
	public static AccountDTO getAccountDto(Account account) {
		AccountDTO accountDTO = new AccountDTO(account.getAccountnumber(), account.getBalance());
		CustomerDTO customerDTO = CustomerAdapter.getCustomerDto(account.getCustomer());
		accountDTO.setCustomer(customerDTO);
		for (AccountEntry accountEntry : account.getEntryList()) {
			AccountEntryDTO accountEntryDTO = AccountEntryAdapter.getAccountEntryDto(accountEntry);
			accountDTO.addEntry(accountEntryDTO);
		}
		return accountDTO;
	}
}
