package approach3;

public class FileLogger extends Logger{

	protected void openLogRepository() {
    	System.out.println("Opening File.");
    }
	protected void writeLogMessage(String message) {
    	System.out.println("Appending Log message to file : " + message);
    }
	protected void closeLogRepository() {
    	System.out.println("Close File.");
    }
}