package bank.service.adapter;

import bank.domain.AccountEntry;
import bank.service.dto.AccountEntryDTO;

public class AccountEntryAdapter {
	public static AccountEntryDTO getAccountEntryDto(AccountEntry accountEntry) {
		AccountEntryDTO accountEntryDTO = new AccountEntryDTO(accountEntry.getDate(), accountEntry.getAmount(),
				accountEntry.getDescription(), accountEntry.getFromAccountNumber(), accountEntry.getFromPersonName());
		return accountEntryDTO;
	}

}
