package service;

public class BlueValueHandler extends ValueHandler {

	public BlueValueHandler(ValueHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handleValue(int value) {
		boolean odd = value % 2 != 0;
		if ( odd && value < 15 || value == 17 || value == 19) {
			System.out.println("Blue");
		} else {
			nextHandler.handleValue(value);
		}		
	}

}
