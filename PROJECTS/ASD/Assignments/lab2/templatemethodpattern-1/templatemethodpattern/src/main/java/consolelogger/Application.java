package consolelogger;

import consolelogger.LogMessage.LogLevel;

public class Application {

	public static void main(String[] args) {
		FileLogger fileLogger = new FileLogger();
		LogMessage message = new LogMessage("cannot send email", "smpt server smtp.acme.com cannot be reached", LogLevel.ERROR);
		fileLogger.log(message);
		System.out.println("------------------------");
		DatabaseLogger databaseLogger = new DatabaseLogger();
		LogMessage message2 = new LogMessage("subject is empty", "this email has no subject, emails should have a subject", LogLevel.INFO);
		databaseLogger.log(message2);
		System.out.println("------------------------");
		ConsoleLogger consoleLogger = new ConsoleLogger();
		LogMessage message3 = new LogMessage("this email has multiple receivers", "try the mailmerge functionality", LogLevel.WARNING);
		consoleLogger.log(message3);

	}
}
