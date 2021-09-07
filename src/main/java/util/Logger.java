package util;

import org.apache.log4j.LogManager;

public class Logger {
	private static org.apache.log4j.Logger log = LogManager.getLogger(Logger.class);
	public static org.apache.log4j.Logger getLog() {
		return log;
	}
}
