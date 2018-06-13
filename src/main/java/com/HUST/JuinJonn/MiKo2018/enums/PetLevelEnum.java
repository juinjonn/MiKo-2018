package com.HUST.JuinJonn.MiKo2018.enums;

public enum PetLevelEnum {
    ORDINARY(1, "普通"),
    RARE(2, "稀有"),
    EPIC(3, "史诗"),
    LEGEND(4, "传说");
    Integer code;
    String text;

    PetLevelEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public static String getTextMeaning(int value) {
        for (PetLevelEnum examType : PetLevelEnum.values()) {
            if (value == examType.getCode()) {
                return examType.getText();
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
}
