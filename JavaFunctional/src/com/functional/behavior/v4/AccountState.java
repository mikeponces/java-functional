package com.functional.behavior.v4;

import java.math.BigDecimal;
import java.util.function.Consumer;

public interface AccountState {

	AccountState deposit(BigDecimal amount, Consumer<BigDecimal> addToBalance);

	AccountState withdraw(BigDecimal amount, Consumer<BigDecimal> subtractFromBalance);

}
