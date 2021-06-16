package org.example.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static String brazilDateTimeFormatter(String dateTime){
        if (dateTime != null) {
            DateTimeFormatter inputDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss-03:00");
            DateTimeFormatter outputDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime localDateTime = LocalDateTime.parse(dateTime, inputDateTime);
            return outputDateTime.format(localDateTime);
        }
        else {
            return null;
        }
    }
}
