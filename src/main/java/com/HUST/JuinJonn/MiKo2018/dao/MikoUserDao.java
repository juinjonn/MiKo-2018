package com.HUST.JuinJonn.MiKo2018.dao;

import com.HUST.JuinJonn.MiKo2018.model.MikoUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MikoUserDao {

    /**
     * 插入一个新的用户
     *
     * @param mikoUser 要插入
     */
    @Insert("insert into miko_user " +
            "(user_account_number,user_passWord,user_balance,create_time,update_time,cipher_text,public_text,is_admin)" +
            "values" +
            "(#{userAccountNumber},#{userPassWord},#{userBalance},#{createTime},#{updateTime},#{cipherText},#{publicText},#{isAdmin})")
    void insertUser(MikoUser mikoUser);

    /**
     * 根据账号查密码
     *
     * @param userAccountNumber
     * @return
     */
    @Select("select *from miko_user where user_account_number = #{userAccountNumber}")
    MikoUser selectMikoUserByAccount(String userAccountNumber);

    @Select("select *from miko_user where cipher_text = #{userCipherText}")
    MikoUser selectMikoUserByCipher(String userCipherText);

    @Update("update miko_user set user_balance=#{balance} where cipher_text = #{userCipherText}")
    void updateUserBalance(@Param("balance") Integer balance, @Param("userCipherText") String userCipherText);
}
