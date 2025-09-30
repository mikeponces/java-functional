package com.functional.lambdas;

import java.util.List;

public class Quiz {
	
	interface MathOp {
	    int operate(int a, int b);
	}

	public static void main(String[] args) {
        List<String> words = List.of(
        		"hello", "world", "java");

        words.forEach(System.out::println);
    }
}
