package service;

public class OrangeValueHandler extends ValueHandler{

	public OrangeValueHandler(ValueHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handleValue(int value) {
		boolean odd = value % 2 != 0;
		if ( odd && value >= 15 && value != 17 && value != 19) {
			System.out.println("Orange");
		} else {
			nextHandler.handleValue(value);
		}		
	}

}
