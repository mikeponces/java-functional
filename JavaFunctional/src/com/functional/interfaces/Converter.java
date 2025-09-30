package com.functional.interfaces;

@FunctionalInterface
public interface Converter {
	String convert(Integer i);
}

class Utils {
    static String format(String s) {
        return "Value: " + s;
    }
}

Converter c = Utils::format;

class ConversionProcessor {
	String process(Integer input, Converter converter) {
		return converter.convert(input);
	}
}

class ConverterService {
	private final ConversionProcessor processor = new ConversionProcessor();

	public String convert(Integer input) {
		return processor.process(input, this::asText);
	}

	public String convertEnhanced(Integer input) {
		return processor.process(input, this::asEnhancedText);
	}

	private String asText(Integer i) {
		return "Number: " + i;
	}

	private String asEnhancedText(Integer i) {
		if (i < 0) {
			return "Negative numbers not allowed";
		}
		String prefix = (i % 2 == 0) ? "Even: " : "Odd: ";
		return prefix + i;
	}
}

class Test {

	public static void main(String[] args) {
//		Converter c; // Step 0

		// Step 1: String convert(Integer i);

//		Converter c = (Integer i); // Step 2
//		
//		Converter c = (i); // Step 3
//		
//		Converter c = (i) -> ; // Step 4
//		
//		Converter c = (i) -> "Number"+i; // Step 5

		// In-line
		Converter c1 = i -> "Number " + i;

		// Code block
		Converter c2 = i -> {
			if (i < 0) {
				return "Negative numbers not allowed";
			}
			String prefix = (i % 2 == 0) ? "Even: " : "Odd: ";
			return prefix + i;
		};

//		Converter c3 = i -> {
//		    if (i < 0) {
//		        System.out.println("Warning: Negative input detected: " + i);
//		        return "Invalid";
//		    }
//
//		    if (i == 0) {
//		        return "Zero";
//		    }
//
//		    String prefix;
//		    if (i % 2 == 0) {
//		        prefix = "Even";
//		    } else {
//		        prefix = "Odd";
//		    }
//
//		    String details = prefix + " number: " + i;
//
//		    if (i > 100) {
//		        return details + " (large)";
//		    } else {
//		        return details + " (small)";
//		    }
//		};
		c1.convert(1);
		c2.convert(2);
		c3.convert(3);

		Converter c3 = i -> test(i);
		
		Converter c = i -> {
		    "Number " + i;
		};
	}

	private static String test(Integer i) {
		if (i < 0) {
			System.out.println("Warning: Negative input detected: " + i);
			return "Invalid";
		}

		if (i == 0) {
			return "Zero";
		}

		String prefix;
		if (i % 2 == 0) {
			prefix = "Even";
		} else {
			prefix = "Odd";
		}

		String details = prefix + " number: " + i;

		if (i > 100) {
			return details + " (large)";
		} else {
			return details + " (small)";
		}
	}

	void convert(Integer value) {
		// object instantiation
		Converter anonymous = new Converter() {
			@Override
			public String convert(Integer i) {
				return "Number" + i;
			}
		};

		anonymous.convert(value);

		// lambda
		Converter functional = i -> "Number" + i;

		functional.convert(value);
	}
}

//	void convert(Integer value) {
//		Converter c = i -> "Number" + i;
//		
//		c.convert(value);
//	}