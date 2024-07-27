package counter;

public class Counter extends Subject{
	
	private int count=0;

	private CounterHandler counterState;


	public void setCounterState(CounterHandler counterState) {
		this.counterState = counterState;
	}

	public void increment(){

		counterState.increment();
    	donotify(count);
	}
	
	public void decrement(){
		counterState.decrement();
    	donotify(count);
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}
}
