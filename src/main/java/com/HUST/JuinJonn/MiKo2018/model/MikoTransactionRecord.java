package com.HUST.JuinJonn.MiKo2018.model;

import lombok.Data;

@Data
public class MikoTransactionRecord {
    private Integer id;
    private String  recordHashCode;
    private String  preRecordHashCode;
    private Integer areaNum;
    private Integer listNum;
    private Integer transactionCount;
    private String buyerCipherText;
    private String sellerCipherText;
    private String dogNumber;
}
