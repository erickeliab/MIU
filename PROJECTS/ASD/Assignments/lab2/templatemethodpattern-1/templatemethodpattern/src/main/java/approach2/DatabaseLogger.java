package approach2;

public class DatabaseLogger extends Logger{
    public void log(LogMessage message) {
        String messageToLog = serializeMessage(message);
        connectToDatabase();
        insertLogMessageToTable(messageToLog);
        closeDbConnection();
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
