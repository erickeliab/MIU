package counter;

public class TripleDigit extends CounterState{

	public TripleDigit(Counter counter) {
		super(counter);
	}

	@Override
	public int increment() {
		int value = counter.getCount();
		value = value + 3;
		return value;
	}

	@Override
	public int decrement() {
		int value = counter.getCount();
		value = value - 3;
		if (value <= 100)
			counter.setState(new DoubleDigit(counter));
		return value;
	}

}

