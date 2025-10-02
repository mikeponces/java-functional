package com.functional.advanced;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MoreLambdas {

	public static void main(String[] args) {
		new MoreLambdas().chainConsumers();
		new MoreLambdas().chainPredicates();
	}

	public void supplierExamples() {
		// UUID
		Supplier<String> randomId = () -> UUID.randomUUID().toString();
		System.out.println("Random ID 1: " + randomId.get());
		System.out.println("Random ID 2: " + randomId.get());

		// Random Number
		Supplier<Integer> randomInt = () -> 
				ThreadLocalRandom.current().nextInt(100);
				
		System.out.println("Random Int 1: " + randomInt.get());
		System.out.println("Random Int 2: " + randomInt.get());

		// Config value
		Supplier<Boolean> isIniEnabled = Const::isEnabled;
		System.out.println(isIniEnabled.get());
	}

	public void consumerExamples(List<Record> expiredRecords) {

		// printing
		Consumer<String> printer1 = s -> System.out.println(s);
		printer.accept("hello");

		// collecting
		List<Record> terminatedRecords = List.of(new Record("1"), new Record("2"));
		terminatedRecords.forEach(expiredRecords::add);

		// mutating
		expiredRecords.forEach(Record::disable);
		
		Consumer<String> printer = s -> 
							System.out.println("Hello " + s);
		printer.accept("Enzo");
		
	}

	public void predicateExamples() {
		Predicate<String> isShort = s -> s.length() < 5;
		Predicate<String> startsWithA = s -> s.startsWith("A");

		// validation
		System.out.println(isShort.test("hi")); // true
		System.out.println(startsWithA.test("champ")); // false

		// filtering
		List<String> names = List.of("Enzo", "Kenneth", "Al", "Aruni");
		List<String> shortNames = names.stream().filter(isShort).collect(toList());
		System.out.println(shortNames); // Enzo, Al
	}

	public void functionExamples() {

		User rose = new User(1, "Rose", "Risk Manager");
		
		// mapping
		Function<User, String> getName = user -> user.getName();
		String name = getName.apply(rose);
		System.out.println(name); // Rose

		// transform
		Function<User, UserDto> toDto = user -> new UserDto(
													user.getId(),
													user.getName().toUpperCase());
		UserDto roseDto = toDto.apply(rose);
		System.out.println(roseDto); // UserDto{id=1, name='ROSE'}
		
	}

	public void chainConsumers() {
		Consumer<String> c1 = s -> System.out.println("c1 consumes: " + s);
		Consumer<String> c2 = s -> System.out.println("c2 consumes: " + s);
		Consumer<String> c3 = c1.andThen(c2);

		c3.accept("Hello");
		// c1 consumes: Hello
		// c2 consumes: Hello
	}

	public void chainPredicates() {
		Predicate<String> isNull = s -> s == null;
		Predicate<String> isEmpty = s -> s.isEmpty();
		Predicate<String> p = isNull.negate().and(isEmpty.negate());

		System.out.println("For null: " + p.test(null)); // false
		System.out.println("For empty: " + p.test("")); // false
		System.out.println("For Hello: " + p.test("Hello")); // true
	}

	public void chainFunctions() {
		Function<Meter, Double> retrieveTemperature = meter -> meter.getTemperature();
		Function<Double, Double> convertToFarenheit = celcius -> (celcius * 9 / 5) + 32d;

		Function<Meter, Double> retrieveFarenheit = retrieveTemperature.andThen(convertToFarenheit);

		retrieveFarenheit.apply(new Meter(33.5));
	}
}

class User {

	public User(int id, String string, String title) {
		// TODO Auto-generated constructor stub
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return null;
	}

}

class UserDto {

	public UserDto(Object id, String upperCase) {
		// TODO Auto-generated constructor stub
	}

}

class Record {
	boolean active = true;

	public Record(String string) {
		// TODO Auto-generated constructor stub
	}

	void disable() {
		active = false;
	}
}

class Const {
	static boolean isEnabled() {
		return true;
	}
}

class Meter {

	public Double celcius;

	public Meter(Double celcius) {
		this.celcius = celcius;
	}

	public Double getTemperature() {
		return celcius;
	}

}