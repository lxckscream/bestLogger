package ru.screamoov.bestlogger.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String getDateAndTime() {
        return LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE) + " " + LocalTime.now().format(DateTimeFormatter.BASIC_ISO_DATE) + " ";
    }
}
