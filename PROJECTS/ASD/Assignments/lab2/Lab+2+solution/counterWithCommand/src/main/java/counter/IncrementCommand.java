package counter;


public class IncrementCommand implements ICommand{
	private Counter counter;
	
	
	public IncrementCommand(Counter counter) {
		this.counter = counter;
	}

	public void execute() {
		counter.increment();
	}


	public void unExecute() {
		counter.decrement();
	}

}
