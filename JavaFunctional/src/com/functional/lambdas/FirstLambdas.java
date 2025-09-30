package com.functional.lambdas;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FirstLambdas {

	public void inline() {
		// Supplier
		Supplier<String> supplier = () -> "Hello!";

		String string = supplier.get();
		System.out.println(string);

		// Consumer
		Consumer<String> consumer = (String s) -> System.out.println(s);
		consumer.accept("Hello");
	}

	public void withBody() {
		// Supplier
		Supplier<String> supplier = () -> {
			System.out.println("I am inside the Consumer");
			return "Hello!";
		};

		String string = supplier.get();
		System.out.println(string);

		// Consumer
		Consumer<String> consumer = (String s) -> {
			System.out.println("I am inside the Consumer");
			System.out.println(s);
		};
		consumer.accept("Hello");
	}
}
