package by.mordas.demoproject.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeConverter {

	private static DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	public static LocalDateTime getLocaleDateTime(String dateTime){
        dateTime=dateTime.replace('T',' ');
        return LocalDateTime.parse(dateTime,formatter);
    }
}
