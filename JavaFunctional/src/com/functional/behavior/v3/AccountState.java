package com.functional.behavior.v3;

import java.math.BigDecimal;

public interface AccountState {

	AccountState deposit(BankAccount account, BigDecimal amount);

	AccountState withdraw(BankAccount account, BigDecimal amount);

}
