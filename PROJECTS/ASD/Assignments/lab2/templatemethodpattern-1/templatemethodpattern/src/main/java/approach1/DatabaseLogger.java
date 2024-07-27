package approach1;

public class DatabaseLogger {
    public void log(LogMessage message) {
        String messageToLog = serializeMessage(message);
        connectToDatabase();
        insertLogMessageToTable(messageToLog);
        closeDbConnection();
    }
    private String serializeMessage(LogMessage message) {
        System.out.println("Serializing message");
        return message.toString();
    }
    private void connectToDatabase() {
    	System.out.println("Connecting to Database.");
    }
    private void insertLogMessageToTable(String message) {
    	System.out.println("Inserting Log Message to DB table : " + message);
    }
    private void closeDbConnection() {
    	System.out.println("Closing DB connection.");
    }
}
