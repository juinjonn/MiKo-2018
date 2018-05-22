package com.HUST.JuinJonn.MiKo2018.dao;
import com.HUST.JuinJonn.MiKo2018.model.MikoUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MikoUserDao {

    /**
     * 插入一个新的用户
     * @param mikoUser 要插入
     */
    @Insert("insert into miko_user " +
            "(user_account_number,user_passWord,user_balance,create_time,update_time,cipher_text,is_admin)" +
            "values" +
            "(#{userAccountNumber},#{userPassWord},#{userBalance},#{createTime},#{updateTime},#{ciphertext},#{isAdmin})")
    void insertUser(MikoUser mikoUser);

    /**
     * 根据账号查密码
     * @param userAccountNumber
     * @return
     */
    @Select("select *from miko_user where user_account_number = #{userAccountNumber}")
    MikoUser selectMikoUserByAccount(String userAccountNumber);
}
