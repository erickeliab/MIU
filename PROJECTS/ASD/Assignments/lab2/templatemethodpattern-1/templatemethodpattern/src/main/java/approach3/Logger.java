package approach3;


public abstract class Logger {
	protected void log(LogMessage message) {
        String messageToLog = serializeMessage(message);
        openLogRepository();
        writeLogMessage(messageToLog);
        closeLogRepository();
    }
    protected abstract void openLogRepository() ;
    protected abstract void writeLogMessage(String message);
    protected abstract void closeLogRepository();

    protected String serializeMessage(LogMessage message) {
        System.out.println("Serializing message");
        return message.toString();
    }

}
