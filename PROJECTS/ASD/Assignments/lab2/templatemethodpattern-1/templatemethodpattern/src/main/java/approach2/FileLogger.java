package approach2;

public class FileLogger extends Logger{
    public void log(LogMessage message) {
        String messageToLog = serializeMessage(message);
        openFile();
        writeLogMessage(messageToLog);
        closeFile();
    }
    private void openFile() {
    	System.out.println("Opening File.");
    }
    private void writeLogMessage(String message) {
    	System.out.println("Appending Log message to file : " + message);
    }
    private void closeFile() {
    	System.out.println("Close File.");
    }
}