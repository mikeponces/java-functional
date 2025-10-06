package com.functional.behavior.v3;

import java.math.BigDecimal;

// version 3 - passing values works but breaks encapsulation

public class BankAccount {
	private BigDecimal balance;
	private AccountState state; // Unverified, Dormant, Active

	public BankAccount(BigDecimal initialDeposit) {
		this.balance = initialDeposit;
		this.state = new Unverified();
	}

	public void deposit(BigDecimal amount) {
		this.state = state.deposit(this, amount);
	}

	public void withdraw(BigDecimal amount) {
		this.state = state.withdraw(this, amount);
	}
	
	public void credit(BigDecimal amount) {
		this.balance = this.balance.add(amount);
	}

	public void debit(BigDecimal amount) {
		this.balance = this.balance.subtract(amount);
	}
}

class Dormant implements AccountState {
	public AccountState deposit(BankAccount account, BigDecimal amount) {
		account.credit(amount);
		return new Active();
	}

	public AccountState withdraw(BankAccount account, BigDecimal amount) {
		account.debit(amount);
		return new Active();
	}
}

class Unverified implements AccountState {
	public AccountState deposit(BankAccount account, BigDecimal amount) {
		account.credit(amount);
		return this;
	}

	public AccountState withdraw(BankAccount account, BigDecimal amount) {
		return this; // PREVENT withdrawal
	}
}



class Active implements AccountState {
	@Override
	public AccountState deposit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountState withdraw() {
		// TODO Auto-generated method stub
		return null;
	}

}
