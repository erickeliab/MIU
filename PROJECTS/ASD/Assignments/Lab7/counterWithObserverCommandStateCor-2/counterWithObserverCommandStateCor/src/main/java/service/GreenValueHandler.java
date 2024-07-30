package service;

public class GreenValueHandler extends ValueHandler{

	public GreenValueHandler(ValueHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handleValue(int value) {
		boolean even = value % 2 == 0;
		if ( (even && value >= 10 && value != 12 && value != 13)) {
			System.out.println("Green");
		} else {
			nextHandler.handleValue(value);
		}

	}

}
