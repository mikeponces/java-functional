package com.functional.interfaces;

public class Greeter {

	public void runExample() {    	
    	MessageFormatter formatter = this::createGreeting;
    	
    	// instead of: (name, times) -> createGreeting(name, times)
    }

    private String createGreeting(String name, int times) {
        return "Hello " + name + ", repeated " + times + " times!";
    }
}

interface MessageFormatter {
    String format(String name, int times);
}
