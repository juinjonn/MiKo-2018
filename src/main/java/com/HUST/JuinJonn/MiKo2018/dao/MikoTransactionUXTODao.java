package com.HUST.JuinJonn.MiKo2018.dao;

import com.HUST.JuinJonn.MiKo2018.model.MikoTransactionUXTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MikoTransactionUXTODao {

    @Insert("insert into miko_transaction_UXTO" +
            "(transaction_id,transaction_output,buyer_balance,transaction_input,seller_balance,transaction_dogs)" +
            "values" +
            "(#{transactionId},#{transactionOutput},#{buyerBalance},#{transactionInput},#{sellerBalance},#{transactionDogsNum}) ")
    void insertUXTO(MikoTransactionUXTO mikoTransactionUXTO);

    @Select("select * from miko_transaction_UXTO where transaction_output = #{seller}")
    List<MikoTransactionUXTO> selectUXTOSeller(String seller);

    @Select("select * from miko_transaction_UXTO where transaction_output = #{buyer}")
    List<MikoTransactionUXTO> selectUXTOBuyer(String buyer);

    @Select(" select transaction_id from miko_transaction_UXTO order by id desc LIMIT 1")
    Integer selectTransactionId();

}
