package integration;

import java.util.Date;

import domain.Observer;

public class Logger implements Observer{
	public void log(int countervalue) {
		System.out.println(new Date()+" Log counter with value "+countervalue);
	}


	public void update(int countervalue) {
		log(countervalue);		
	}

}
