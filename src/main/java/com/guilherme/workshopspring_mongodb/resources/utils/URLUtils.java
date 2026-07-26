package com.guilherme.workshopspring_mongodb.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLUtils {

    public static String decodeUrl(String msg){
        try {
            return URLDecoder.decode(msg, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }

    }

}
