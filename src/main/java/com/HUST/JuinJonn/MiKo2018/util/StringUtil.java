package com.HUST.JuinJonn.MiKo2018.util;

import com.google.common.base.CharMatcher;

public class StringUtil {
    public static String splitPrice(String price) {
        return CharMatcher.DIGIT.retainFrom(price);
    }
}
