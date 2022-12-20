package com.sgenlecroyant.spring.security.util;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Constants {
	
	private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd", Locale.US);
	
	public static DateTimeFormatter getDateTimeFormatter() {
		return dateTimeFormatter;
	}

}
