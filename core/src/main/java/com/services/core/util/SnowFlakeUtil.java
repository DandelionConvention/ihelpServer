package com.services.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * snowflake算法生成id
 */
public class SnowFlakeUtil
{
    private static final Logger logger = LoggerFactory.getLogger(SnowFlakeUtil.class);
    /**
     * 起始时间
     */
    private final static String START_TIME = "2020-01-01T00:00:00.000";
    /**
     * 时区
     */
    private final static int HOURS = 8;
    /**
     * 起始时间戳
     */
    private final static long START_TIMESTAMP = TimeUtil.timeStringToEpochMilli(START_TIME, HOURS);
    /**
     * 序列号位数
     */
    private final static long SEQUENCE_BITS = 15L;
    /**
     * 机器标识位数
     */
    private final static long MACHINE_BITS = 3L;
    /**
     * 最大序列
     */
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BITS);
    /**
     * 机器标识的左移位数
     */
    private final static long MACHINE_SHIFT = SEQUENCE_BITS;
    /**
     * 时间差的左移位数
     */
    private final static long TIME_SHIFT = SEQUENCE_BITS + MACHINE_BITS;
    /**
     * 机器标识
     */
    private final static long MACHINE_ID = 1L;
    /**
     * 序列
     */
    private static long sequence = 0L;
    /**
     * 上次时间戳
     */
    private static long lastTimestamp = 0L;

    /**
     * 生成id
     *
     * @param currentTimestamp 当前时间戳
     * @return id
     */
    public static synchronized long nextId(long currentTimestamp)
    {
        if (currentTimestamp < lastTimestamp)
        {
            logger.warn("时钟回拨->currentTimestamp: {}, lastTimestamp: {}", currentTimestamp, lastTimestamp);
            currentTimestamp = lastTimestamp;
        }
        if (lastTimestamp != currentTimestamp)
        {
            lastTimestamp = currentTimestamp;
            sequence = 0L;
        }
        sequence++;
        long next = sequence & MAX_SEQUENCE;
        if (next == 0)
        {
            logger.warn("序列在1毫秒内达到上限: {}", currentTimestamp);
            return nextId(currentTimestamp + 1L);
        }
        return ((currentTimestamp - START_TIMESTAMP) << TIME_SHIFT) | (next << MACHINE_SHIFT) | MACHINE_ID;
    }
}