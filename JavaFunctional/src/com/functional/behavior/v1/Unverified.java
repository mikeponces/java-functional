package com.functional.behavior.v1;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class Unverified implements AccountState {

	@Override
	public AccountState verify() {
		return new Active();
	}

	@Override
	public AccountState close() {
		return new Closed();
	}

	@Override
	public AccountState freeze() {
		return this;
	}

	@Override
	public AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance) {
		addToBalance.accept(amount);
		return this;
	}

	@Override
	public AccountState withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromBalance) {
		return this;
	}

}
