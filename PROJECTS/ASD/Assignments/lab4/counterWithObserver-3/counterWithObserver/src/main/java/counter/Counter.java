package counter;

public class Counter extends Subject{
	
	private int count=0;
	
	public void increment(){
		count++;
    	donotify(count);
	}
	
	public void decrement(){
		count--;
    	donotify(count);
	}

}
