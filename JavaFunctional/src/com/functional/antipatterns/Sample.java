package com.functional.antipatterns;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class Sample {
	
	private Logger log = Logger.getLogger(Sample.class.getName());
	
	public void readability(Integer value) {
		
		Predicate<Integer> isPositive = x -> x > 0;

		if (isPositive.test(value)) {
		    System.out.println("Positive");
		}

		if (value > 0) {
		    System.out.println("Positive");
		}

	}

	public void overEngineering(List<Record> records) {
		
		Consumer<Record> processRecord = r -> log.info("Processing " + r.getId());
		processRecord = processRecord.andThen(r -> r.disable())
									 .andThen(r -> notify(r));

		records.forEach(processRecord);

		for (Record r : records) {
			log.info("Processing " + r.getId());
			r.disable();
			notify(r);
		}

	}

	private Object notify(Record r) {
		// TODO Auto-generated method stub
		return null;
	}
}

class Record {

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object disable() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
