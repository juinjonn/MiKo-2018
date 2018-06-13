package com.HUST.JuinJonn.MiKo2018.controller;


import com.HUST.JuinJonn.MiKo2018.constant.PetConstant;
import com.HUST.JuinJonn.MiKo2018.dto.SaleDogsDto;
import com.HUST.JuinJonn.MiKo2018.model.MikoDog;
import com.HUST.JuinJonn.MiKo2018.model.MikoUser;
import com.HUST.JuinJonn.MiKo2018.service.SelectDogsService;
import com.HUST.JuinJonn.MiKo2018.service.TransactionService;
import com.HUST.JuinJonn.MiKo2018.util.CookieUtil;
import com.HUST.JuinJonn.MiKo2018.util.JsonUtil;
import com.HUST.JuinJonn.MiKo2018.util.SelectToDtoUtil;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/Miko")
public class MyInformationController {
    @Autowired
    SelectDogsService selectDogsService;
    @Autowired
    TransactionService transactionService;

    @ResponseBody
    @RequestMapping(value = "/myDogs")
    public String myInformation(HttpServletRequest request) {
        MikoUser mikoUser = selectDogsService.selectUserByAccount(CookieUtil.getUserAccount(request));
        Preconditions.checkNotNull(mikoUser,"查询失败，没有查到用户或没有登录");
        List<MikoDog> userDogs = selectDogsService.selectDogsByUserCipher(mikoUser.getCipherText());
        return JsonUtil.ObjectToJson(SelectToDtoUtil.selectDogsToDto(userDogs, PetConstant.SELECT_MY_DOG_CONROLLER));
    }

    @ResponseBody
    @RequestMapping(value = "/saleDog")
    public Boolean saleDog(SaleDogsDto saleDogsDto){
        Preconditions.checkNotNull(saleDogsDto);
        if(transactionService.saleDog(saleDogsDto)){
            return true;
        }
        return false;
    }
}
