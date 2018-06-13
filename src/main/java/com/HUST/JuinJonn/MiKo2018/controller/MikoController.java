package com.HUST.JuinJonn.MiKo2018.controller;

import com.HUST.JuinJonn.MiKo2018.dto.MyInformationDto;
import com.HUST.JuinJonn.MiKo2018.model.MikoDog;
import com.HUST.JuinJonn.MiKo2018.model.MikoUser;
import com.HUST.JuinJonn.MiKo2018.service.SelectDogsService;
import com.HUST.JuinJonn.MiKo2018.service.SelectMyInformationService;
import com.HUST.JuinJonn.MiKo2018.service.TransactionService;
import com.HUST.JuinJonn.MiKo2018.util.CookieUtil;
import com.HUST.JuinJonn.MiKo2018.util.JsonUtil;
import com.HUST.JuinJonn.MiKo2018.util.SelectToDtoUtil;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = {"/Miko", "/"})
public class MikoController {
    @Autowired
    private SelectDogsService selectDogsService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private SelectMyInformationService selectMyInformationService;
    @RequestMapping(value = "/")
    public String miko() {

        return "miko";
    }

    @ResponseBody
    @RequestMapping(value = "/selectSellDogs")
    public String selectSellDogs() {

        List<MikoDog> listDogs = selectDogsService.selectDogsByOnSale();
        return JsonUtil.ObjectToJson(SelectToDtoUtil.selectDogsToDto(listDogs));
    }

    @ResponseBody
    @RequestMapping(value = "/buyDog")
    public String buyDog(HttpServletRequest request, String dogNumber) {
        MikoUser mikoUser = selectDogsService.selectUserByAccount(CookieUtil.getUserAccount(request));
        return transactionService.transacteDogs(mikoUser.getUserAccountNumber(), dogNumber);


    }

    @ResponseBody
    @RequestMapping(value = "/myInFormation")
    public String selectMyInFormation(HttpServletRequest request) {
       MyInformationDto myInformationDto = selectMyInformationService.selectMyInformation(CookieUtil.getUserAccount(request));
        return JsonUtil.ObjectToJson(myInformationDto);
    }

    @ResponseBody
    @RequestMapping(value = "/loginOut")
    public void loginOut(HttpServletResponse response, HttpServletRequest request) {
        Cookie cookieArr[] = request.getCookies();
        Preconditions.checkNotNull(cookieArr);
        for (Cookie cookie : cookieArr) {
            if (cookie.getName().equals("userCookie")) {
                Cookie cookieNew = new Cookie("userCookie",null);
                cookieNew.setMaxAge(0);
                cookieNew.setPath("/");//根据你创建cookie的路径进行填写
                response.addCookie(cookieNew);
            }
        }
        return ;
    }

}
