package com.HUST.JuinJonn.MiKo2018.service;

import com.HUST.JuinJonn.MiKo2018.constant.PetConstant;
import com.HUST.JuinJonn.MiKo2018.dao.MikoDogDao;
import com.HUST.JuinJonn.MiKo2018.dao.MikoUserDao;
import com.HUST.JuinJonn.MiKo2018.model.MikoDog;
import com.HUST.JuinJonn.MiKo2018.model.MikoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectDogsService {
    @Autowired
    MikoDogDao mikoDogDao;
    @Autowired
    MikoUserDao mikoUserDao;
    public List<MikoDog> selectDogsByOnSale(){
        return mikoDogDao.selectDogByIsSale(PetConstant.SAlEING);
    }

    public MikoUser selectUserByAccount(String userAccount){
        return mikoUserDao.selectMikoUserByAccount(userAccount);
    }

    public List<MikoDog> selectDogsByUserCipher(String cipherText){
        return mikoDogDao.selectDogByUser(cipherText);

    }
}
