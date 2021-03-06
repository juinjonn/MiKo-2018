package com.HUST.JuinJonn.MiKo2018.controller;

import com.HUST.JuinJonn.MiKo2018.dto.MikoUserIdPwd;
import com.HUST.JuinJonn.MiKo2018.service.LoginService;
import com.HUST.JuinJonn.MiKo2018.util.JsonUtil;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/Miko")
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login")
    public String login(HttpServletResponse response, HttpServletRequest request) {
        Cookie cookieArr[] = request.getCookies();
        if (cookieArr != null) {
            for (Cookie cookie : cookieArr) {
                if (cookie.getName().equals("userCookie")) {
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    break;
                }

            }
        }
        return "login";
    }


    @ResponseBody
    @RequestMapping(value = "/loginUser")
    public boolean setLoginCookie(HttpServletResponse response, MikoUserIdPwd userInfo) {
        Preconditions.checkNotNull(userInfo);
        if (!loginService.checkPwd(userInfo)) {
            return false;
        }
        Cookie cookie = new Cookie("userCookie", userInfo.getUserName());
        cookie.setMaxAge(60 * 60 * 24);//保存24小时
        cookie.setPath("/");
        response.addCookie(cookie);
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "/registered")
    public String registered(HttpServletResponse response, MikoUserIdPwd userInfo) {
        Preconditions.checkNotNull(userInfo);
        String status = loginService.checkUserId(userInfo);
        if (status.equals(new String("注册成功"))) {
            Cookie cookie = new Cookie("userCookie", userInfo.getUserName());
            cookie.setMaxAge(60 * 60 * 24);//保存24小时
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return JsonUtil.ObjectToJson(status);
    }
}
