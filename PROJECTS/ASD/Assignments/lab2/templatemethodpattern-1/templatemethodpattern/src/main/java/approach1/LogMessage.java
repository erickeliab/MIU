package approach1;

import java.time.LocalDate;
import java.time.LocalTime;

public class LogMessage {
	enum LogLevel {
		  WARNING,
		  INFO,
		  ERROR
		}
	
	private String message;
	private String details;
	private LogLevel level;
	
	public LogMessage(String message, String details, LogLevel level) {
		this.message = message;
		this.details = details;
		this.level = level;
	}

	@Override
	public String toString() {
		return "LogMessage "+LocalDate.now()+" - "+LocalTime.now()+" [message=" + message + ", details=" + details + ", level=" + level + "]";
	}
}
