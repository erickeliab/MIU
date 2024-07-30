package service;

import dataaccess.CounterDAO;
import domain.Counter;
import domain.CounterState;
import domain.Observer;
import domain.SingleDigit;
import integration.Logger;

public class CounterService {
	
	private Counter counter;
	ValueHandler handler;
	
	public CounterService() {
		counter = new Counter();
		// set initial state
		CounterState state= new SingleDigit(counter);
		counter.setState(state);
		// set the observers
		counter.addObserver(new CounterDAO());
		counter.addObserver(new Logger());
		// create the chain
		handler = new OrangeValueHandler(null);
		handler = new BlueValueHandler(handler);
		handler = new GreenValueHandler(handler);
		handler = new RedValueHandler(handler);
		
	}

	public void increment() {
		counter.increment();
		handler.handleValue(counter.getCount());
	}
	
	public void decrement() {
		counter.decrement();
		handler.handleValue(counter.getCount());
	}
	
	public void addObserver(Observer observer) {
		counter.addObserver(observer);
	}

}
