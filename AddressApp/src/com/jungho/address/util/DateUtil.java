package com.jungho.address.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {
	private static final String DATE_PATTERN = "dd.MM.yyyy";
	private static final DateTimeFormatter DATE_FORMATTER = 
			DateTimeFormatter.ofPattern(DATE_PATTERN);
	
	public static String foramt(LocalDate date) {
		if (date == null) {
			return null;
		}
//		System.out.println(date.toString());
		return DATE_FORMATTER.format(date);
//		return date.toString();
	}
	
	public static LocalDate parse(String dateString) {
		try {
			return DATE_FORMATTER.parse(dateString, LocalDate::from);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean vaildDate(String dateString) {
		return DateUtil.parse(dateString) != null;
	}
}
