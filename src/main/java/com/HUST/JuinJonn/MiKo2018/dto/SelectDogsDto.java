package com.HUST.JuinJonn.MiKo2018.dto;

import com.HUST.JuinJonn.MiKo2018.constant.PetConstant;
import com.HUST.JuinJonn.MiKo2018.enums.*;
import com.HUST.JuinJonn.MiKo2018.model.MikoDog;
import lombok.Data;

@Data
public class SelectDogsDto {
    private String dogNumber;
    private String petEyes;
    private String petMouth;
    private String petPattern;
    private String petWing;
    private String petLevel;
    private String petPrice;

    public SelectDogsDto(MikoDog mikoDog) {
        dogNumber = mikoDog.getDogNumber();
        petEyes = PetEyesEnum.getTextMeaning(mikoDog.getPetEyes());
        petMouth = PetMouthEnum.getTextMeaning(mikoDog.getPetMouth());
        petPattern = PetPatternEnum.getTextMeaning(mikoDog.getPetPattern());
        petWing = PetWingsEnum.getTextMeaning(mikoDog.getPetWing());
        petLevel = PetLevelEnum.getTextMeaning(mikoDog.getPetLevel());
        if (mikoDog.getIsFlag() == PetConstant.ONFLAG) {
            petPrice = "上链中。。。。";
        } else {
            petPrice = mikoDog.getPetPrice().toString() + "M币";
        }
    }

    public SelectDogsDto(MikoDog mikoDog, String type) {
        dogNumber = mikoDog.getDogNumber();
        petEyes = PetEyesEnum.getTextMeaning(mikoDog.getPetEyes());
        petMouth = PetMouthEnum.getTextMeaning(mikoDog.getPetMouth());
        petPattern = PetPatternEnum.getTextMeaning(mikoDog.getPetPattern());
        petWing = PetWingsEnum.getTextMeaning(mikoDog.getPetWing());
        petLevel = PetLevelEnum.getTextMeaning(mikoDog.getPetLevel());


        if (mikoDog.getIsSale() == PetConstant.SAlEING) {
            petPrice = "出售中，价格为" + mikoDog.getPetPrice() + "M币";
        } else {
            petPrice = mikoDog.getPetPrice() + "M币";
        }

        if (mikoDog.getIsFlag() == PetConstant.ONFLAG) {
            petPrice = "上链中。。。。";
        }
    }
}

