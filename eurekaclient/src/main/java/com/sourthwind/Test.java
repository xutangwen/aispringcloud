package com.sourthwind;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {
    public static long compareDate(String startDate, String endDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        long time1 = 0;
        long time2 = 0;

        cal.setTime(dateFormat.parse(startDate));
        time1 = cal.getTimeInMillis();
        cal.setTime(dateFormat.parse(endDate));
        time2 = cal.getTimeInMillis();
        return time2 - time1;
    }

    public static void main(String[] args) {
        try {
            final long l = compareDate("20220101", "20220121");
            System.out.println(l);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
