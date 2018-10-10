package com.team.springboot.myspringboot.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class DateUtil {
    // 取得本地时间：
    private static Calendar cal = Calendar.getInstance();
    // 取得时间偏移量：
    private static int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
    // 取得夏令时差：
    private static int dstOffset = cal.get(Calendar.DST_OFFSET);

    /**
     * 缺省的日期显示格式： yyyy-MM-dd
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 缺省的日期时间显示格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * UTC格式时间串：yyyy-MM-ddTHH:mm:ss.SSSZ
     */
    public static final String UTC_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    /**
     * 一天的总毫秒数
     */
    public static final long ONE_DAY_MILLISECONDS = 86400000;

    /**
     * 一分钟的总毫秒数
     */
    public static final long ONE_MINUTE_MILLISECONDS = 60000;

    /**
     * 一小时的总毫秒数
     */
    public static final long ONE_HOUR_MILLISECONDS = 3600000;

    /**
     * 比较两个时间相差的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int dateDiff(Date date1, Date date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(date1);
        String time2 = sdf.format(date2);
        try {
            date1 = sdf.parse(time);
            date2 = sdf.parse(time2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long d1 = date1.getTime();
        long d2 = date2.getTime();
        long dif = d1 > d2 ? d1 - d2 : d2 - d1;
        return Integer.parseInt(String.valueOf(dif / ONE_DAY_MILLISECONDS));
    }

    /**
     * 检查字符串是否符合指定格式
     *
     * @param dateString 日期字符串
     * @param pattern    日期格式
     * @return
     */
    public static boolean validateDate(String dateString, String pattern) {
        if (StringUtils.isEmpty(dateString))
            return false;

        if (StringUtils.isEmpty(pattern))
            return false;

        try {
            new SimpleDateFormat(pattern).parse(dateString);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    /**
     * 格式化标准时间成Date
     *
     * @param dateString 标准时间
     * @param pattern    时间格式类型 如"yyyy-MM-dd HH:mm:ss"
     * @return
     * @throws Exception
     */
    public static Date makeDate(String dateString, String pattern) {
        if (StringUtils.isEmpty(dateString))
            return null;
        try {
            return new SimpleDateFormat(StringUtils.defaultString(pattern,
                    DEFAULT_DATETIME_FORMAT)).parse(dateString);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 获取多少分钟以前的时间
     *
     * @param minute
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String getLatelyDate(long minute) {
        long nowTime = new Date().getTime();
        long paramTime = nowTime - (ONE_MINUTE_MILLISECONDS * minute);
        return new Date(paramTime).toLocaleString();
    }

    /**
     * 判断输入时间是否为当天
     *
     * @param d
     * @return
     */
    @SuppressWarnings("deprecation")
    public static boolean isCurrentDay(Date d) {
        Date d0 = new Date();
        d0.setHours(0);
        d0.setMinutes(0);
        d0.setSeconds(0);
        Date d1 = new Date();
        d1.setHours(23);
        d1.setMinutes(59);
        d1.setSeconds(59);
        return d.after(d0) && d.before(d1);
    }

    /**
     * 得到系统当前时间
     *
     * @return 当前日期时间
     */
    public static Date getNow() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 得到用缺省方式得到格式化后的系统时间字符串 默认格式：yyyy-MM-dd HH:mm:ss
     *
     * @return 当前日期及时间
     */
    public static String getDateTime() {
        return getDateTime(DEFAULT_DATETIME_FORMAT);
    }

    /**
     * 得到指定格式的系统时间字符串
     *
     * @param pattern 显示格式
     * @return 格式化后的系统时间字符串
     */
    public static String getDateTime(String pattern) {
        Date datetime = Calendar.getInstance().getTime();
        if (StringUtils.isEmpty(pattern))
            pattern = DEFAULT_DATETIME_FORMAT;

        return getDateTime(datetime, pattern);
    }

    /**
     * 将制定日期格式化成指定格式
     *
     * @param date    需要进行格式化的日期
     * @param pattern 日期格式
     * @return 格式化后的日期时间字符串
     */
    public static String getDateTime(Date date, String pattern) {
        if (StringUtils.isEmpty(pattern)) {
            pattern = DEFAULT_DATETIME_FORMAT;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    public static String getDateTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return dateFormat.format(date);
    }

    /**
     * 得到当前系统时间的年份
     *
     * @return 当前年份
     */
    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * 得到当前系统时间的月份
     *
     * @return 当前月份
     */
    public static int getCurrentMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    /**
     * 得到当前当前系统时间的日
     *
     * @return 当前日
     */
    public static int getCurrentDay() {
        return Calendar.getInstance().get(Calendar.DATE);
    }

    /**
     * 得到当前当前系统时间的小时
     *
     * @return 当前小时
     */
    public static int getCurrentHour() {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 取得当前日期以后若干天的日期。
     *
     * @param days 变更的天数
     * @return
     */
    public static Date getAfterDays(int days) {
        return add(getNow(), days, Calendar.DATE);
    }

    /**
     * 取Date以后的若干分钟
     *
     * @param date
     * @param mintues
     * @return
     */
    public static Date addMinutes(Date date, int mintues) {
        return org.apache.commons.lang3.time.DateUtils
                .addMinutes(date, mintues);
    }

    /**
     * 取当前时间以后的若干分钟
     *
     * @param mintues
     * @return
     */
    public static Date addMinutes(int mintues) {
        return addMinutes(new Date(), mintues);
    }

    /**
     * 取得当前日期之前若干天的日期。
     *
     * @param days 变更的天数
     * @return
     */
    public static Date getBeforeDays(int days) {
        return add(getNow(), beforeDay(days), Calendar.DATE);
    }

    /**
     * 取得指定日期以后若干天的日期。
     *
     * @param date 基准日期
     * @param days 变更的天数
     * @return
     */
    public static Date getAfterDays(Date date, int days) {
        return add(date, days, Calendar.DATE);
    }

    /**
     * 取得指定日期之前若干天的日期。
     *
     * @param date 基准日期
     * @param days 变更的天数
     * @return
     */
    public static Date getBeforeDays(Date date, int days) {
        return add(date, beforeDay(days), Calendar.DATE);
    }

    private static int beforeDay(int days) {
        return 0 - days;
    }

    /**
     * 取得当前日期以后某月的日期。如果要得到以前月份的日期，参数用负数。
     *
     * @param months 增加的月份数
     * @return 增加以后的日期
     */
    public static Date addMonths(int months) {
        return add(getNow(), months, Calendar.MONTH);
    }

    /**
     * 取得指定日期以后某月的日期。如果要得到以前月份的日期，参数用负数。 注意，可能不是同一日子，例如2003-1-31加上一个月是2003-2-28
     *
     * @param date   基准日期
     * @param months 增加的月份数
     * @return 增加以后的日期
     */
    public static Date addMonths(Date date, int months) {
        return add(date, months, Calendar.MONTH);
    }

    /**
     * 内部方法。为指定日期增加相应的天数或月数
     *
     * @param date   基准日期
     * @param amount 增加的数量
     * @param field  增加的单位，年，月或者日
     * @return 增加以后的日期
     */
    private static Date add(Date date, int amount, int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * 把长整数时间转换为日期对象
     *
     * @param date
     * @return
     */
    public static Date getDateFromLong(long date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);
        return calendar.getTime();
    }

    /**
     * 计算两个日期相差分钟数。 用第一个日期减去第二个。如果前一个日期小于后一个日期，则返回负数
     *
     * @param one 第一个日期数，作为基准
     * @param two 第二个日期数，作为比较
     * @return 两个日期相差天数
     */
    public static long diffMins(Date one, Date two) {
        return (one.getTime() - two.getTime()) / ONE_MINUTE_MILLISECONDS;
    }

    /**
     * 计算两个日期相差小时数。 用第一个日期减去第二个。如果前一个日期小于后一个日期，则返回负数
     *
     * @param one 第一个日期数，作为基准
     * @param two 第二个日期数，作为比较
     * @return 两个日期相差天数
     */
    public static long diffHours(Date one, Date two) {
        return (one.getTime() - two.getTime()) / ONE_HOUR_MILLISECONDS;
    }

    /**
     * 计算两个日期相差天数。 用第一个日期减去第二个。如果前一个日期小于后一个日期，则返回负数
     *
     * @param one 第一个日期数，作为基准
     * @param two 第二个日期数，作为比较
     * @return 两个日期相差天数
     */
    public static long diffDays(Date one, Date two) {
        return (one.getTime() - two.getTime()) / ONE_DAY_MILLISECONDS;
    }

    /**
     * 计算两个日期相差月份数 如果前一个日期小于后一个日期，则返回负数
     *
     * @param one 第一个日期数，作为基准
     * @param two 第二个日期数，作为比较
     * @return 两个日期相差月份数
     */
    public static int diffMonths(Date one, Date two) {
        Calendar calendar = Calendar.getInstance();
        // 得到第一个日期的年分和月份数
        calendar.setTime(one);
        int yearOne = calendar.get(Calendar.YEAR);
        int monthOne = calendar.get(Calendar.MONDAY);
        // 得到第二个日期的年份和月份
        calendar.setTime(two);
        int yearTwo = calendar.get(Calendar.YEAR);
        int monthTwo = calendar.get(Calendar.MONDAY);
        return (yearOne - yearTwo) * 12 + (monthOne - monthTwo);
    }

    /**
     * 将一个字符串用给定的格式转换为日期类型 注意：如果返回null，则表示解析失败
     *
     * @param dateStr 需要解析的日期字符串
     * @param pattern 日期字符串的格式，默认为“yyyy-MM-dd”的形式
     * @return 解析后的日期
     */
    public static Date parse(String dateStr, String pattern) {
        Date date = null;
        if (null == pattern || "".equals(pattern)) {
            pattern = DEFAULT_DATE_FORMAT;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            log.error("================日期转换失败==============");
        }
        return date;
    }

    /**
     * 返回本月的最后一天
     *
     * @return 本月最后一天的日期
     */
    public static Date getMonthLastDay() {
        return getMonthLastDay(getNow());
    }

    /**
     * 返回给定日期中的月份中的最后一天
     *
     * @param date 基准日期
     * @return 该月最后一天的日期
     */
    public static Date getMonthLastDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 将日期设置为下一月第一天
        calendar.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1, 1);
        // 减去1天，得到的即本月的最后一天
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 把年、月、日转换为日期
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.getTime();
    }

    /**
     * 获取某个月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Integer getMonthLastDay(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);
        // 减去1天，得到的即本月的最后一天
        calendar.add(Calendar.DATE, -1);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 把年、月、日拼接成yyyy-MM-dd返回
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String getDateString(Integer year, Integer month, Integer day) {
        String returnDateString = year + "-";
        if (month < 10) {
            returnDateString = returnDateString + "0" + month + "-";
        } else {
            returnDateString = returnDateString + month + "-";
        }
        if (day < 10) {
            returnDateString = returnDateString + "0" + day;
        } else {
            returnDateString = returnDateString + day;
        }
        return returnDateString;
    }

    /**
     * 获取当天时间字符串 yyyy-MM-dd
     *
     * @return yyyy-MM-dd
     */
    public static String getDate() {
        return getDateTime(DEFAULT_DATE_FORMAT);
    }

    /**
     * 获取当天起始时间字符串 yyyy-MM-dd
     *
     * @return yyyy-MM-dd
     */
    public static String getDateBegin() {
        return getDate() + " 00:00:00";
    }

    /**
     * 获取当天起始时间字符串 yyyy-MM-dd
     *
     * @return yyyy-MM-dd
     */
    public static String getDatetimeBegin() {
        return getDateBegin() + " 00:00:00";
    }

    /**
     * 获取当天结束时间字符串 yyyy-MM-dd
     *
     * @return yyyy-MM-dd
     */
    public static String getDateEnd() {
        return getDate() + " 23:59:59";
    }

    /**
     * 获取本周第一天
     *
     * @return
     */
    public static Date getMonday() {
        Calendar calendar = Calendar.getInstance();
        int nowWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (nowWeek == Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, -6);
        } else {
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        }
        return calendar.getTime();
    }

    /**
     * 获取本周第一天
     *
     * @return yyyy-MM-dd
     */
    public static String getMondayStr() {
        return getDateTime(getMonday(), DEFAULT_DATE_FORMAT);
    }

    /**
     * 获取本周第一天
     *
     * @return yyyy-MM-dd 00:00:00
     */
    public static String getMondayBeginStr() {
        return getMondayStr() + " 00:00:00";
    }

    /**
     * 获取本周的周日
     *
     * @return
     */
    public static Date getSunday() {
        Calendar calendar = Calendar.getInstance();
        int nowWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (nowWeek > Calendar.SUNDAY) {
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            calendar.add(Calendar.DAY_OF_MONTH, 6);
        }
        return calendar.getTime();
    }

    /**
     * 获取本周周日
     *
     * @return yyyy-mm-dd 23:59:59
     */
    public static String getSundayStr() {
        return getDateTime(getSunday(), DEFAULT_DATE_FORMAT);
    }

    /**
     * 获取本周周日
     *
     * @return yyyy-mm-dd 23:59:59
     */
    public static String getSundayEndStr() {
        return getSundayStr() + " 23:59:59";
    }

    /**
     * 获取每月第一天
     *
     * @return
     */
    public static Date getMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取每月第一天
     *
     * @return yyyy-MM-dd
     */
    public static String getMonthFirstDayStr() {
        return getDateTime(getMonthFirstDay(), DEFAULT_DATE_FORMAT);
    }

    /**
     * 获取每月第一天
     *
     * @return yyyy-MM-dd 00:00:00
     */
    public static String getMonthFirstDayBeginStr() {
        return getMonthFirstDayStr() + " 00:00:00";
    }

    /**
     * 获取每月最后一天 yyy-Mm-dd
     */
    public static String getMonthLastDayStr() {
        return getDateTime(getMonthLastDay(), DEFAULT_DATE_FORMAT);
    }

    /**
     * 获取每月最后一天 yyy-MM-dd 23:59:59
     */
    public static String getMonthLastDayEndStr() {
        return getMonthLastDayStr() + " 23:59:59";
    }

    /**
     * 获取时间字符串用来生成唯一的id
     *
     * @return
     */
    public static String getIdByTime() {
        return getDateTime("yyyyMMddHHmmss");
    }

    /**
     * 把本地时间串yyyy-MM-dd HH:mm:ss转换为utc时间串yyyy-MM-ddTHH:mm:ss.SSSZ
     *
     * @return
     */
    public static String localToUtcString(String localTime) {
        Date date = parse(localTime, DEFAULT_DATETIME_FORMAT);
        date = add(date, -(zoneOffset + dstOffset), Calendar.MILLISECOND);
        return getDateTime(date, UTC_DATETIME_FORMAT);
    }

    public static void main(String[] args) {
        System.out.println(
                getDateTime(
                        DateUtil.parse(DateUtil.getMondayBeginStr(), DEFAULT_DATETIME_FORMAT),
                        DEFAULT_DATETIME_FORMAT
                )
        );

        System.out.println(
                getDateTime(
                        DateUtil.parse(DateUtil.getMonthFirstDayBeginStr(), DEFAULT_DATETIME_FORMAT),
                        DEFAULT_DATETIME_FORMAT
                )
        );

        System.out.println(
                getDateTime(
                        DateUtil.parse(DateUtil.getCurrentYear() + "-01-01 00:00:00", DEFAULT_DATETIME_FORMAT),
                        DEFAULT_DATETIME_FORMAT
                )
        );

        System.out.println(
                getDateTime(getMonthLastDay(new Date()))
        );
    }
}
