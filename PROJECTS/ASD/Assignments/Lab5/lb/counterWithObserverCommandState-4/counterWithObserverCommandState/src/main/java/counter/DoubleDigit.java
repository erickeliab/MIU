package counter;

public class DoubleDigit extends CounterState{

	public DoubleDigit(Counter counter) {
		super(counter);
	}

	@Override
	public int increment() {
		int value = counter.getCount();
		value = value + 2;
		if (value >= 100)
			counter.setState(new TripleDigit(counter));
		return value;
	}

	@Override
	public int decrement() {
		int value = counter.getCount();
		value = value - 2;
		if (value <= 10)
			counter.setState(new SingleDigit(counter));
		return value;
	}

}
