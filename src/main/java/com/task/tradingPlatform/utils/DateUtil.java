package com.task.tradingPlatform.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
    public static Calendar getDateFromString(String date) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .parse(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return calendar;
    }

    //Получает дату, время которой на 1 секунду больше,
    //переданной в аргумент. Нужно для удаления записей
    //из таблицы Sales с точностью до секунды.
    public static Calendar getDateOneSecondMore(Calendar calendar) {
        Calendar dateFromOneSec = Calendar.getInstance();
        dateFromOneSec.setTime(calendar.getTime());
        dateFromOneSec.add(Calendar.SECOND, 1);
        return dateFromOneSec;
    }
}
