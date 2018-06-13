package com.HUST.JuinJonn.MiKo2018.enums;

public enum PetMouthEnum {
    TIGER_MOUTH(1, "虎牙嘴"),
    TONGUE_OUT(2, "吐舌头"),
    HAPPY_LAUGH(3, "开心笑"),
    SERIOUS_MOUTH(4, "严肃嘴");
    Integer code;
    String text;

    PetMouthEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public static String getTextMeaning(int value) {
        for (PetMouthEnum examType : PetMouthEnum.values()) {
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
