package counter;

public abstract class CounterState {
    protected Counter counter;
    	
	public CounterState(Counter counter) {
		this.counter = counter;
	}
	public abstract int increment();	
	public abstract int decrement();

}
