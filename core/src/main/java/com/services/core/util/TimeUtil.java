package com.services.core.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 时间工具类
 */
public class TimeUtil
{
    /**
     * 毫秒级时间戳转LocalDateTime
     *
     * @param epochMilli 毫秒级时间戳
     * @param hours 时区
     * @return LocalDateTime
     */
    public static LocalDateTime epochMilliToLocalDateTime(long epochMilli, int hours)
    {
        return Instant.ofEpochMilli(epochMilli).atZone(ZoneOffset.ofHours(hours)).toLocalDateTime();
    }

    /**
     * 毫秒级时间戳转LocalDate
     *
     * @param epochMilli 毫秒级时间戳
     * @param hours 时区
     * @return LocalDate
     */
    public static LocalDate epochMilliToLocalDate(long epochMilli, int hours)
    {
        return Instant.ofEpochMilli(epochMilli).atZone(ZoneOffset.ofHours(hours)).toLocalDate();
    }

    /**
     * 毫秒级时间戳转时间字符串
     *
     * @param epochMilli 毫秒级时间戳
     * @param hours 时区
     * @param pattern 时间格式
     * @return 时间字符串
     */
    public static String epochMilliToTimeString(long epochMilli, int hours, String pattern)
    {
        return epochMilliToLocalDateTime(epochMilli, hours).format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 毫秒级时间戳转日期字符串
     *
     * @param epochMilli 毫秒级时间戳
     * @param hours 时区
     * @param pattern 日期格式
     * @return 日期字符串
     */
    public static String epochMilliToDateString(long epochMilli, int hours, String pattern)
    {
        return epochMilliToLocalDate(epochMilli, hours).format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 秒级时间戳转LocalDateTime
     *
     * @param epochSecond 秒级时间戳
     * @param hours 时区
     * @return LocalDateTime
     */
    public static LocalDateTime epochSecondToLocalDateTime(long epochSecond, int hours)
    {
        return Instant.ofEpochSecond(epochSecond).atZone(ZoneOffset.ofHours(hours)).toLocalDateTime();
    }

    /**
     * 秒级时间戳转LocalDate
     *
     * @param epochSecond 秒级时间戳
     * @param hours 时区
     * @return LocalDate
     */
    public static LocalDate epochSecondToLocalDate(long epochSecond, int hours)
    {
        return Instant.ofEpochSecond(epochSecond).atZone(ZoneOffset.ofHours(hours)).toLocalDate();
    }

    /**
     * 秒级时间戳转时间字符串
     *
     * @param epochSecond 秒级时间戳
     * @param hours 时区
     * @param pattern 时间格式
     * @return 时间字符串
     */
    public static String epochSecondToTimeString(long epochSecond, int hours, String pattern)
    {
        return epochSecondToLocalDateTime(epochSecond, hours).format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 秒级时间戳转日期字符串
     *
     * @param epochSecond 秒级时间戳
     * @param hours 时区
     * @param pattern 时间格式
     * @return 日期字符串
     */
    public static String epochSecondToDateString(long epochSecond, int hours, String pattern)
    {
        return epochSecondToLocalDate(epochSecond, hours).format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * LocalDateTime转毫秒级时间戳
     *
     * @param localDateTime 本地时间
     * @param hours 时区
     * @return 毫秒级时间戳
     */
    public static long localDateTimeToEpochMilli(LocalDateTime localDateTime, int hours)
    {
        return localDateTime.toInstant(ZoneOffset.ofHours(hours)).toEpochMilli();
    }

    /**
     * LocalDateTime转秒级时间戳
     *
     * @param localDateTime 本地时间
     * @param hours 时区
     * @return 秒级时间戳
     */
    public static long localDateTimeToEpochSecond(LocalDateTime localDateTime, int hours)
    {
        return localDateTime.toInstant(ZoneOffset.ofHours(hours)).getEpochSecond();
    }

    /**
     * LocalDate转毫秒级时间戳
     *
     * @param localDate 本地日期
     * @param hours 时区
     * @return 毫秒级时间戳
     */
    public static long localDateToEpochMilli(LocalDate localDate, int hours)
    {
        return localDate.atStartOfDay(ZoneOffset.ofHours(hours)).toInstant().toEpochMilli();
    }

    /**
     * LocalDate转秒级时间戳
     *
     * @param localDate 本地时间
     * @param hours 时区
     * @return 秒级时间戳
     */
    public static long localDateToEpochSecond(LocalDate localDate, int hours)
    {
        return localDate.atStartOfDay(ZoneOffset.ofHours(hours)).toInstant().getEpochSecond();
    }

    /**
     * 时间字符串转毫秒级时间戳
     *
     * @param s 时间字符串：yyyy-MM-dd'T'HH:mm:ss.SSS，例如：2000-01-01T00:00:00.000
     * @param hours 时区
     * @return 毫秒级时间戳
     */
    public static long timeStringToEpochMilli(String s, int hours)
    {
        return localDateTimeToEpochMilli(LocalDateTime.parse(s), hours);
    }

    /**
     * 时间字符串转秒级时间戳
     *
     * @param s 时间字符串：yyyy-MM-dd'T'HH:mm:ss.SSS，例如：2000-01-01T00:00:00.000
     * @param hours 时区
     * @return 秒级时间戳
     */
    public static long timeStringToEpochSecond(String s, int hours)
    {
        return localDateTimeToEpochSecond(LocalDateTime.parse(s), hours);
    }

    /**
     * 日期字符串转毫秒级时间戳
     *
     * @param s 日期字符串：yyyy-MM-dd，例如：2000-01-01
     * @param hours 时区
     * @return 毫秒级时间戳
     */
    public static long dateStringToEpochMilli(String s, int hours)
    {
        return localDateToEpochMilli(LocalDate.parse(s), hours);
    }

    /**
     * 日期字符串转秒级时间戳
     *
     * @param s 日期字符串：yyyy-MM-dd，例如：2000-01-01
     * @param hours 时区
     * @return 秒级时间戳
     */
    public static long dateStringToEpochSecond(String s, int hours)
    {
        return localDateToEpochSecond(LocalDate.parse(s), hours);
    }

    /**
     * 日期字符串转LocalDate
     *
     * @param s 日期字符串
     * @param pattern 格式
     * @return
     */
    public static LocalDate dateStringToLocalDate(String s, String pattern)
    {
        return LocalDate.parse(s, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取xx后
     *
     * @param localDate
     * @return
     */
    public static String getGeneration(LocalDate localDate)
    {
        String year = String.valueOf(localDate.getYear());
        return year.substring(year.length() - 2, year.length() - 1) + "0";
    }
}
