package counter;

public class SingleDigit extends CounterState{

	public SingleDigit(Counter counter) {
		super(counter);
	}

	@Override
	public int increment() {
		int value = counter.getCount();
		value = value + 1;
		if (value >= 10)
			counter.setState(new DoubleDigit(counter));
		return value;
	}

	@Override
	public int decrement() {
		int value = counter.getCount();
		value = value - 1;
		return value;
	}

}

