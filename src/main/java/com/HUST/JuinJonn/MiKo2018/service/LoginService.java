package com.HUST.JuinJonn.MiKo2018.service;

import com.HUST.JuinJonn.MiKo2018.dao.MikoUserDao;
import com.HUST.JuinJonn.MiKo2018.dto.MikoUserIdPwd;
import com.HUST.JuinJonn.MiKo2018.model.MikoUser;
import com.HUST.JuinJonn.MiKo2018.util.GetRandStringUtil;
import com.HUST.JuinJonn.MiKo2018.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    public static final Integer CIPHERLENGTH = 10;
    @Autowired
    MikoUserDao mikoUserDao;
    public boolean checkPwd(MikoUserIdPwd mikoUser){
        MikoUser checkUser = mikoUserDao.selectMikoUserByAccount(mikoUser.getUserName());
        if (checkUser.getUserPassWord().equals(mikoUser.getPassWord())){
            return true;
        }else {
            return false;
        }

    }

    public String checkUserId(MikoUserIdPwd mikoUser) {
        MikoUser checkUser = mikoUserDao.selectMikoUserByAccount(mikoUser.getUserName());
        if (checkUser == null){
            MikoUser newUser = new MikoUser();
            String cipherText = GetRandStringUtil.getRandomString(CIPHERLENGTH);
            String publicText = GetRandStringUtil.EncoderByMd5(cipherText);
            newUser.setUserAccountNumber(mikoUser.getUserName());
            newUser.setUserPassWord(mikoUser.getPassWord());
            newUser.setUserBalance(3000);
            newUser.setCipherText(cipherText);
            newUser.setPublicText(publicText);
            mikoUserDao.insertUser(newUser);
            return "注册成功";
        }else {
            return "该用户名已经被注册";
        }
    }
}
