package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerHelper {

	public static Logger getLogger(Class<?> clazz)
	{
		LoggerFactory.getLogger(clazz);
		return LoggerFactory.getLogger(clazz);
	}
}
