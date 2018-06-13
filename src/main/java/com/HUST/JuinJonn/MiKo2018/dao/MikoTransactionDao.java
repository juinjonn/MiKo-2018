package com.HUST.JuinJonn.MiKo2018.dao;

import com.HUST.JuinJonn.MiKo2018.model.MikoDog;
import com.HUST.JuinJonn.MiKo2018.model.MikoTransaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MikoTransactionDao {

    @Insert("insert into miko_transaction " +
            "(buyer_text,seller_text,dog_number,is_flag)" +
            "values" +
            "(#{buyerText},#{sellerText},#{dogNumber},#{isFlag})")
    void insertTransaction();

    @Select("select *from miko_transaction where isFlag = #{isFlag}")
    List<MikoTransaction> isFlag(Boolean isFlag);

    /**
     * 根据卖家查询交易狗的信息
     *
     * @param sellerText
     * @return
     */
    @Select("select * from miko_transaction where seller_cipher = #{sellerText}")
    List<MikoDog> selectDogBySellerCipher(String sellerText);

    /**
     * 根据买家查询交易狗的信息
     *
     * @param buyerText
     * @return
     */
    @Select("select * from miko_transaction where buyer_cipher = #{buyerText}")
    List<MikoDog> selectDogByBuyerCipher(String buyerText);
}
