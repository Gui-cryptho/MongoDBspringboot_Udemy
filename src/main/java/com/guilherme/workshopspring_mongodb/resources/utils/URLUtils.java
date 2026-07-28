package com.guilherme.workshopspring_mongodb.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URLUtils {

    public static String decodeUrl(String msg){
        try {
            return URLDecoder.decode(msg, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }

    }

    public static LocalDate stringFormatter(String date, LocalDate defaultValue) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            return LocalDate.parse(date, fmt);
        } catch (DateTimeParseException e) {
            return defaultValue;
        }
    }

}
