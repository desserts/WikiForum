package net.savebar.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by hxy on 16/5/2.
 */
public class DateUtil {


    /**
     * 设置时间
     *
     * @param year        年
     * @param month       月
     * @param day         日
     * @param hour        小时
     * @param minute      分钟
     * @param second      秒
     * @param millisecond 毫秒
     * @return date
     */
    public static Date makeDate(int year, int month, int day, int hour, int minute, int second, int millisecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, millisecond);
        return new Date(calendar.getTimeInMillis());
    }

    /**
     * <pre>
     *     DateUtils.computeYearRanges("2007-3-24", "2007-3-25")
     *     //will return
     *     // Arrays.asList(new DateUtils.DateSequence(parseDate("2007-03-24:00-00-00"), parseDate("2007-03-25:00-00-00")),
     *                new DateUtils.DateSequence(parseDate("2007-03-25:00-00-00"), parseDate("2007-03-26:00-00-00")),
     * </pre>
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return list
     */
    public static List<DateSequence> computeDayRanges(Date startDate, Date endDate) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        Date trueStart = DateUtil.makeDate(startCalendar.get(Calendar.YEAR), startCalendar.get(Calendar.MONTH) + 1, startCalendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0, 0);
        Date trueEnd = DateUtil.makeDate(endCalendar.get(Calendar.YEAR), endCalendar.get(Calendar.MONTH) + 1, endCalendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0, 0);
        List<DateSequence> results = new ArrayList<>();
        long betweenDays = (trueEnd.getTime() - trueStart.getTime()) / ((1000 * 60 * 60 * 24));
        int range = Integer.parseInt(String.valueOf(betweenDays)) + 1;
        for (int i = 0; i < range; i++) {
            Date start = DateUtils.addDays(trueStart, i);
            Date end = DateUtils.addDays(start, 1);
            DateSequence dateSequence = new DateSequence(start, end);
            results.add(dateSequence);
        }
        return results;
    }

    public static class DateSequence {
        private Date start;
        private Date end;

        public DateSequence(Date start, Date end) {
            this.start = start;
            this.end = end;
        }

        public Date getStart() {
            return start;
        }

        public Date getEnd() {
            return end;
        }


        public int getStartYear() {
            Calendar temp = Calendar.getInstance();
            temp.setTime(start);
            return temp.get(Calendar.YEAR);
        }

        public int getStartMonth() {
            Calendar temp = Calendar.getInstance();
            temp.setTime(start);
            return temp.get(Calendar.MONTH) + 1;
        }

        public int getStartDay() {
            Calendar temp = Calendar.getInstance();
            temp.setTime(start);
            return temp.get(Calendar.DAY_OF_MONTH);

        }
    }

    /**
     * 格式化时间
     *
     * @return String
     */
    public static String formatTime(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
}
