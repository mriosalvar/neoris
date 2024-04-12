package com.pruebatecnica.neorisapi.util;

import lombok.experimental.UtilityClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

@UtilityClass
public class DateValidator {

    private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Timestamp parseTimestamp(String input) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIMESTAMP_FORMAT);
        dateFormat.setLenient(false);
        return new Timestamp(dateFormat.parse(input).getTime());
    }

}
