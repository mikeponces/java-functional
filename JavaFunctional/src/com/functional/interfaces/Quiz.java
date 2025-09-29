package com.functional.interfaces;

public class Quiz {

	public static void main(String[] args) {
		
		Runnable r = new Runnable() {
		    @Override
		    public void run() {
		        System.out.println("Running...");
		    }
		};

		r.run();
	}
}

interface Printer {
    void print(String message);

    default void hello() {
        System.out.println("Hello");
    }
}

@FunctionalInterface
interface Calculator {
    int add(int a, int b);
    
    int subtract(int a, int b);
}

