package bank.integration;

import bank.domain.Account;
import bank.service.IAccountService;

public abstract class Observer {
  IAccountService accountService;

  public Observer(IAccountService accountService) {
    this.accountService = accountService;
  }

  public abstract void update();
}
