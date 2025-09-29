package com.functional.interfaces;

@FunctionalInterface
public interface Converter {

	String convert(Integer i);
}

class Test {
	void convert(Integer value) {
		Converter c = new Converter() {
			@Override
			public String convert(Integer i) {
				return "Number" + i;
			}
		};

		c.convert(value);
	}
}

//	void convert(Integer value) {
//		Converter c = i -> "Number" + i;
//		
//		c.convert(value);
//	}