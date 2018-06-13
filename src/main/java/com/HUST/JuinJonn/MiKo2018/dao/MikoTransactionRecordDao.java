package com.HUST.JuinJonn.MiKo2018.dao;

import com.HUST.JuinJonn.MiKo2018.model.MikoTransactionRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MikoTransactionRecordDao {
    /**
     * 插入一条交易记录
     *
     * @param mikoTransactionRecord
     */
    @Insert("insert into miko_transaction_record_table " +
            "(pre_record_hashcode,record_hashcode,transaction_orders,area_num)" +
            "values" +
            "(#{preRecordHashCode},#{recordHashCode},#{transactionOrders},#{areaNum})")
    void insertTransactionRecord(MikoTransactionRecord mikoTransactionRecord);

    /**
     * 根据交易记录的HashCode查询该条记录的详细信息
     *
     * @param recordHashCode
     * @return
     */
    @Select("select * from miko_transaction_record_table where record_hashcode = #{recordHashCode}")
    MikoTransactionRecord selectRecordByHashCode(String recordHashCode);

    @Select("select record_hashcode from miko_transaction_record_table order by id desc LIMIT 1")
    String selectPreRecordHash();

    @Select(" select area_num from miko_transaction_record_table order by id desc LIMIT 1")
    Integer selectAreaNumLast();
}
