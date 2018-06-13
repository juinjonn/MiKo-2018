package com.HUST.JuinJonn.MiKo2018.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MikoTransactionRecord {
    private Integer id;
    private String  recordHashCode;
    private String  preRecordHashCode;
    private Integer areaNum;
    private String transactionOrders;

}
