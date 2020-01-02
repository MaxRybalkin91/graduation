package ru.topjava.graduation.util;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;

public class CurrentTimeUtil {

    public static boolean isTimeOver() {
        return getLocalTime().isAfter(LocalTime.of(11, 0));
    }

    private static LocalTime getLocalTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return LocalTime.parse(sdf.format(cal.getTime()));
    }
}
