package com.functional.behavior.v1;

import java.math.BigDecimal;

// version 1 - missing state update & sensitive functions are public

public class BankAccount {
	private BigDecimal balance;
	private AccountState state; // Unverified, Dormant, Active
	
	public BankAccount(BigDecimal initialDeposit) {
		this.balance = initialDeposit;
		this.state = new Unverified();
	}
	
	public void deposit(BigDecimal amount) {
		this.balance = this.balance.add(amount);
	}

	public void withdraw(BigDecimal amount) {
		this.balance = this.balance.subtract(amount);
	}
}