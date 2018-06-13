package com.HUST.JuinJonn.MiKo2018.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MikoTransaction {
    private Integer id;
    private String  buyerText;
    private String  sellerText;
    private String dogNumber;
    private Boolean isFlag;
}
