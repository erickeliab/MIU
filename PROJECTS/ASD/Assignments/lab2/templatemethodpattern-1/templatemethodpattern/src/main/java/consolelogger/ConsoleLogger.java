package consolelogger;

public class ConsoleLogger extends Logger {

	protected void openLogRepository() {}

	protected void writeLogMessage(String message) {
		System.out.println("Console logger: "+message);

	}

	protected void closeLogRepository() {}

}
