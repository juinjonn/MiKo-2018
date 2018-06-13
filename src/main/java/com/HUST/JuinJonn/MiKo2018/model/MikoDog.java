package com.HUST.JuinJonn.MiKo2018.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MikoDog {
    private Integer id;
    private String dogNumber;
    private Boolean isSale;
    private Boolean isReproduction;
    private String ciphertext;
    private Integer petEyes;
    private Integer petMouth;
    private Integer petPattern;
    private Integer petWing;
    private Integer petLevel;
    private Integer petPrice;
    private Integer generationsNum;
    private Boolean isFlag;

}
