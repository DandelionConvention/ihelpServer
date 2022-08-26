package com.services.products.ihelp.service.util;

import java.time.LocalDate;

public class DateUtil
{

    /**
     * LocalDate转换年代Integer
     * @param date 传入LocalDate类型日期
     * @return Integer年代
     */
    public static Integer localDateToDecade(LocalDate date){
        return date.getYear() % 100 - date.getYear() % 10;
    }
}
