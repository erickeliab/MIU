package consolelogger;

public class DatabaseLogger extends Logger{

	protected void openLogRepository() {
    	System.out.println("Connecting to Database.");
    }
	protected void writeLogMessage(String message) {
    	System.out.println("Inserting Log Message to DB table : " + message);
    }
	protected void closeLogRepository() {
    	System.out.println("Closing DB connection.");
    }
}
