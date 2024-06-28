package org.railway.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static String getFormattedDate(int daysAfter) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, daysAfter);
        Date afterDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        return dateFormat.format(afterDate);
    }
}
