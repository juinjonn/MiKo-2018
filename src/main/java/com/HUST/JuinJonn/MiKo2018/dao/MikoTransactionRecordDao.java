package com.HUST.JuinJonn.MiKo2018.dao;

import com.HUST.JuinJonn.MiKo2018.model.MikoDog;
import com.HUST.JuinJonn.MiKo2018.model.MikoTransactionRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MikoTransactionRecordDao {
    /**
     * 插入一条交易记录
     *
     * @param mikoTransactionRecord
     */
    @Insert("insert into miko_transaction_recordTable " +
            "(pre_record_hashcode,record_hashcode,area_num,list_num,transaction_count,buyer_cipher_text,seller_cipher_text,dog_number,)" +
            "values" +
            "(#{preRecordHashCode},#{recordHashCode},#{areaNum},#{listNum},#{transactionCount},#{buyerCipherText},#{sellerCipherText},#{dogNumber})")
    void insertTransactionRecord(MikoTransactionRecord mikoTransactionRecord);

    /**
     * 根据交易记录的HashCode查询该条记录的详细信息
     *
     * @param recordHashCode
     * @return
     */
    @Select("select * from miko_transaction_recordTable where record_hashcode = #{recordHashCode}")
    MikoTransactionRecord selectRecordByHashCode(String recordHashCode);

    /**
     * 根据卖家查询交易狗的信息
     * @param sellerCipher
     * @return
     */
    @Select("select * from miko_transaction_recordTable where seller_cipher = #{sellerCipher}")
    List<MikoDog> selectDogBySellerCipher(String sellerCipher);

    /**
     * 根据买家查询交易狗的信息
     * @param buyerCipher
     * @return
     */
    @Select("select * from miko_transaction_recordTable where buyer_cipher = #{buyerCipher}")
    List<MikoDog> selectDogByBuyerCipher(String buyerCipher);
}
