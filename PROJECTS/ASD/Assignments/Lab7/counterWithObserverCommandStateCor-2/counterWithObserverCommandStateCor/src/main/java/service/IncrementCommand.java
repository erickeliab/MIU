package service;


public class IncrementCommand implements ICommand{
	private CounterService counterService;
	
	
	public IncrementCommand(CounterService counterService) {
		this.counterService = counterService;
	}

	public void execute() {
		counterService.increment();
	}


	public void unExecute() {
		counterService.decrement();
	}

}
