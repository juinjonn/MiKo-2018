package com.HUST.JuinJonn.MiKo2018.service;

import com.HUST.JuinJonn.MiKo2018.dao.MikoUserDao;
import com.HUST.JuinJonn.MiKo2018.dto.MyInformationDto;
import com.HUST.JuinJonn.MiKo2018.model.MikoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectMyInformationService {
    @Autowired
    MikoUserDao mikoUserDao;
    public MyInformationDto selectMyInformation(String userAccount){
        MikoUser mikoUser = mikoUserDao.selectMikoUserByAccount(userAccount);
        MyInformationDto myInformationDto = new MyInformationDto();
        myInformationDto.setUserAccount(userAccount);
        myInformationDto.setBalance(mikoUser.getUserBalance().toString());
        myInformationDto.setUserCipher(mikoUser.getCipherText());
        return myInformationDto;
    }
}
