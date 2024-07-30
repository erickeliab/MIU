package service;

public class RedValueHandler extends ValueHandler	{

	public RedValueHandler(ValueHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handleValue(int value) {
		boolean even = value % 2 == 0;
		if ( (even && (value < 10 || value == 12)) || value == 13) {
			System.out.println("Red");
		} else {
			nextHandler.handleValue(value);
		}
	}

}
