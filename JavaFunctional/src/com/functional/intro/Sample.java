package com.functional.intro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sample {

	double imperative(int[] numbers) {
		// 1. Set x equal to zero
		double x = 0;

		// 2. Add the first number of the array to x
		// 3. Repeat step 2 for the rest of the numbers
		for (int number : numbers) {
			x += number;
		}

		// 4. Divide x by the length of the array
		return x / numbers.length;
	}

	double declarative(int[] numbers) {
		// X is average of all ints in the array
		return Arrays.stream(numbers)
				.average()
				.orElse(0.0);
	}

	public User findFirstUserFromCountrya(List<User> users, String country) {
		User result = null;

		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if (country.equals(u.getCountry())) {
				result = u;
			}
		}

		if (result == null) {
			throw new IllegalArgumentException("No user found from: " + country);
		}
		
		return result;
	}

	public User findFirstUserFromCountry(List<User> users, String country) {
		return users.stream()
				.sorted(Comparator.comparing(User::getId))
				.filter(u -> country.equals(u.getCountry()))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No user found from: " + country));
	}

}

class User {

	public Object getCountry() {
		return null;
	}

	public int getId() {
		return 0;
	}

}
