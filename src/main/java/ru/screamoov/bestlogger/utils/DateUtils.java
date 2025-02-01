package ru.screamoov.bestlogger.utils;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateUtils {
    public static String getDateAndTime() {
        return LocalDate.now() + " " + LocalTime.now() + " ";
    }
}
