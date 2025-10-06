package com.functional.behavior.v2;

import java.math.BigDecimal;

// version 2 - state is updated, but add/subtract always enforced

public class BankAccount {
	private BigDecimal balance;
	private AccountState state; // Unverified, Dormant, Active

	public BankAccount(BigDecimal initialDeposit) {
		this.balance = initialDeposit;
		this.state = new Unverified();
	}

	public void deposit(BigDecimal amount) {
		this.state = state.deposit();
		this.balance = this.balance.add(amount);
	}

	public void withdraw(BigDecimal amount) {
		this.state = state.withdraw();
		this.balance = this.balance.subtract(amount);
	}
}

class Dormant implements AccountState {
	public AccountState deposit() {
		return new Active(); // re-activate, accept deposit
	}

	public AccountState withdraw() {
		return new Active(); // re-activate, accept withdrawal 
	}
}

class Unverified implements AccountState {
	public AccountState deposit() {
		return this; // still unverified, accept deposit
	}

	public AccountState withdraw() {
		return this; // still unverified, PREVENT withdrawal
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
