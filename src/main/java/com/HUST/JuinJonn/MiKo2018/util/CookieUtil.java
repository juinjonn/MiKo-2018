package com.HUST.JuinJonn.MiKo2018.util;

import com.google.common.base.Preconditions;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {
    public static String getUserAccount(HttpServletRequest request) {

        Cookie cookieArr[] = request.getCookies();
        if (cookieArr != null) {
            for (Cookie cookie : cookieArr) {
                if (cookie.getName().equals("userCookie")) {
                    return cookie.getValue();
                }

            }
        }

        return null;
    }
}
