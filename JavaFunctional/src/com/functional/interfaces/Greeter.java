package com.functional.interfaces;

interface MessageFormatter {
    String format(String name, int times);
}

public class Greeter {

    private String createGreeting(String name, int times) {
        return "Hello " + name + ", repeated " + times + " times!";
    }
    
	public void runExample() {    	
    	MessageFormatter lambda = (name, times) -> createGreeting(name, times);
    	
		MessageFormatter methodReference = this::createGreeting;
    }
}


