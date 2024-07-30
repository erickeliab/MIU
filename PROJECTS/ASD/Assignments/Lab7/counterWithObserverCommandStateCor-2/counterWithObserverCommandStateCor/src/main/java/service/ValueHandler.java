package service;

public abstract class ValueHandler {
	protected ValueHandler nextHandler;
	
	
	public ValueHandler(ValueHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public ValueHandler getNextHandler() {
		return nextHandler;
	}
	public abstract void handleValue(int value);
}
