package com.golearnit.util.common;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static final String SPACE = " ";
    public static final String EMPTY = "";
    public static final String LF = "\n";
    public static final String CR = "\r";
    public static final int INDEX_NOT_FOUND = -1;
    private static final int PAD_LIMIT = 8192;

    public StringUtils() {}

    public static String getEmptyIfNull(String strIn) {
        return strIn == null ? "" : strIn;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static boolean isNullOrEmpty(String[] str) {
        return str == null || "".equals(str)  || str.length == 0;
    }


    public static String shrink(String str) {
        return str.replaceAll("\t", " ").replaceAll("\n", " ").replaceAll("\\s+", " ");
    }

    public static List<String> fetchMatchedStrings(String string, Pattern pattern, Integer groupNo) {
        if (string != null && pattern != null) {
            Matcher m = pattern.matcher(string);
            ArrayList subStrings = new ArrayList();

            while (true) {
                while (m.find()) {
                    if (groupNo != null && groupNo != 0) {
                        subStrings.add(m.group(groupNo));
                    } else {
                        subStrings.add(m.group());
                    }
                }

                return subStrings;
            }
        } else {
            return null;
        }
    }

    public static String upperCase(String str) {
        return str == null ? null : str.toUpperCase();
    }

    public static String upperCase(String str, Locale locale) {
        return str == null ? null : str.toUpperCase(locale);
    }

    public static String lowerCase(String str) {
        return str == null ? null : str.toLowerCase();
    }

    public static String lowerCase(String str, Locale locale) {
        return str == null ? null : str.toLowerCase(locale);
    }


    public static String escapeNewLine(String string) {
        string = string.replaceAll("\r\n", " ");
        return string.replaceAll("\n", " ");
    }
}
