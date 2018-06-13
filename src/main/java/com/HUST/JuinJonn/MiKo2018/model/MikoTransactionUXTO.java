package com.HUST.JuinJonn.MiKo2018.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MikoTransactionUXTO {
    private Integer id;
    private Integer transactionId;
    private String transactionOutput;
    private Integer buyerBalance;
    private String transactionInput;
    private Integer sellerBalance;
    private String transactionDogsNum;

}
