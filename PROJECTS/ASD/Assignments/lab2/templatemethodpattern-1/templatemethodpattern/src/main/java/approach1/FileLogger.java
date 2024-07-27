package approach1;

public class FileLogger{
    public void log(LogMessage message) {
        String messageToLog = serializeMessage(message);
        openFile();
        writeLogMessage(messageToLog);
        closeFile();
    }
    private String serializeMessage(LogMessage message) {
        System.out.println("Serializing message");
        return message.toString();
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