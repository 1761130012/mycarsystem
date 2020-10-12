package com.utils;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;

/**
 * web 到 controller 时间参数的处理类    String 提供的时间格式  Date 返回的格式
 */
public class DateConvertUtil implements Converter<String, Date> {
    private String[] parsePatterns;//时间格式 数组 xml 中加载

    public void setParsePatterns(String[] parsePatterns) {
        this.parsePatterns = parsePatterns;
    }

    @Override
    public Date convert(String s) {
        System.out.println("----------------");
        System.out.println(s);
        try {
            return DateUtils.parseDate(s, parsePatterns);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
