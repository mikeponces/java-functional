package com.functional.behavior.v4;

import java.math.BigDecimal;
import java.util.function.Consumer;

// version 4 - pass behavior as value

public class BankAccount {
	private BigDecimal balance;
	private AccountState state; // Unverified, Dormant, Active

	public BankAccount(BigDecimal initialDeposit) {
		this.balance = initialDeposit;
		this.state = new Unverified();
	}

	public void deposit(BigDecimal amount) {
		this.state = state.deposit(amount, this::credit);
	}

	public void withdraw(BigDecimal amount) {
		this.state = state.withdraw(amount, this::debit);
	}
	
	private void credit(BigDecimal amount) {
		this.balance = this.balance.add(amount);
	}

	private void debit(BigDecimal amount) {
		this.balance = this.balance.subtract(amount);
	}
}

class Dormant implements AccountState {
	public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
		addToBalance.accept(amount);
		return new Active();
	}

	public AccountState withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromBalance) {
		subtractFromBalance.accept(amount);
		return new Active();
	}
}

class Unverified implements AccountState {
	public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
		addToBalance.accept(amount);
		return this;
	}

	public AccountState withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromBalance) {
		return this;
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
