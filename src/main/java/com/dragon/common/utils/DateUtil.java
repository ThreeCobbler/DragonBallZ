package com.dragon.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 339939 on 2018/3/27.
 */
public class DateUtil {

    public DateUtil() {
    }

    public static Date getDateStart(Date date) {
        Date dt = DateUtils.setHours(date, 0);
        dt = DateUtils.setMinutes(dt, 0);
        dt = DateUtils.setSeconds(dt, 0);
        dt = DateUtils.setMilliseconds(dt, 0);
        return dt;
    }

    public static boolean isBefore(Date date, int h, int m, int s) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int ch = cal.get(11);
        int cm = cal.get(12);
        int cs = cal.get(13);
        return ch > h?false:(cm > m?false:cs <= s);
    }

    public static Integer daysBetween(Date smallDate, Date bigDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            if(smallDate == null || bigDate == null) {
                return Integer.valueOf(-1);
            }

            smallDate = sdf.parse(sdf.format(smallDate));
            bigDate = sdf.parse(sdf.format(bigDate));
        } catch (ParseException var10) {
            var10.printStackTrace();
            return Integer.valueOf(-1);
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(smallDate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bigDate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / 86400000L;
        return Integer.valueOf(Integer.parseInt(String.valueOf(between_days)));
    }

    public static Date afterDays(Date now, Integer days) {
        long d = (long)days.intValue();
        d = d * 24L * 3600L * 1000L;
        return new Date(now.getTime() + d);
    }

    public static Date monthLastTime(Date date, int beforeMonth) {
        Calendar cal = Calendar.getInstance();
        cal.set(2, cal.get(2) + beforeMonth);
        cal.set(5, cal.getActualMaximum(5));
        cal.set(cal.get(1), cal.get(2), cal.get(5), 23, 59, 59);
        cal.set(14, 999);
        return cal.getTime();
    }

    public static Date monthFirstTime(Date date, int beforeMonth) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(5, 1);
        cal.set(cal.get(1), cal.get(2) + beforeMonth, cal.get(5), 0, 0, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    public static Date beforeDateStartTime(Date date, int before) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(cal.get(1), cal.get(2), cal.get(5) + before, 0, 0, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    public static Date beforeDateLastTime(Date date, int before) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(cal.get(1), cal.get(2), cal.get(5) + before, 23, 59, 59);
        cal.set(14, 999);
        return cal.getTime();
    }

    public static Date oneDateLastTime(Date date) {
        return date == null?date:beforeDateLastTime(date, 0);
    }

    public static Date beforeYearTime(Date date, int before) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(1, before);
        return cal.getTime();
    }

    public static Time getTimeFmt(String time) {
        if(StringUtils.isBlank(time)) {
            return null;
        } else {
            String[] t = time.split(":");
            Calendar cal = Calendar.getInstance();
            cal.set(14, 0);
            cal.set(11, Integer.parseInt(t[0]));
            cal.set(12, Integer.parseInt(t[1]));
            if(t.length >= 3) {
                cal.set(13, Integer.parseInt(t[2]));
            } else {
                cal.set(13, 0);
            }

            return new Time(cal.getTimeInMillis());
        }
    }

    public static String getFormatDate(Date date) {
        String str = "";
        if(date == null) {
            return str;
        } else {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
            return sf.format(date);
        }
    }

    public static String getFormatDate(Date date, String format) {
        String str = "";
        if(date == null) {
            return str;
        } else {
            SimpleDateFormat sf = new SimpleDateFormat(format);
            return sf.format(date);
        }
    }

    public static Date addDate(Date beginDate, int limit) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(5, date.get(5) + limit);

        try {
            return dft.parse(dft.format(date.getTime()));
        } catch (ParseException var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public static Date stringToDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = sdf.parse(dateString);
        } catch (ParseException var4) {
            var4.printStackTrace();
        }

        return date;
    }

    public static String formatSecond(Object second) {
        String html = "0秒";
        if(second != null) {
            Double s = (Double)second;
            Integer hours = Integer.valueOf((int)(s.doubleValue() / 3600.0D));
            Integer minutes = Integer.valueOf((int)(s.doubleValue() / 60.0D - (double)(hours.intValue() * 60)));
            Integer seconds = Integer.valueOf((int)(s.doubleValue() - (double)(minutes.intValue() * 60) - (double)(hours.intValue() * 60 * 60)));
            String format;
            Object[] array;
            if(hours.intValue() > 0) {
                format = "%1$,d时%2$,d分%3$,d秒";
                array = new Object[]{hours, minutes, seconds};
            } else if(minutes.intValue() > 0) {
                format = "%1$,d分%2$,d秒";
                array = new Object[]{minutes, seconds};
            } else {
                format = "%1$,d秒";
                array = new Object[]{seconds};
            }

            html = String.format(format, array);
        }

        return html;
    }

    public static Date getFormatHSMDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;

        try {
            date = sdf.parse(dateString);
        } catch (ParseException var4) {
            var4.printStackTrace();
        }

        return date;
    }

    public static String getFormatDateString(Date date) {
        String str = "";
        if(date == null) {
            return str;
        } else {
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
            return sf.format(date);
        }
    }
}
