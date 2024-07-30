package counter;

public class Counter extends Subject{
	CounterState state;
	
	private int count=0;
	
	public void increment(){
		count=state.increment();
    	donotify(count);
	}
	
	public void decrement(){
		count=state.decrement();
    	donotify(count);
	}

	public void setState(CounterState state) {
		this.state = state;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	

}
