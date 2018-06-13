package com.HUST.JuinJonn.MiKo2018.enums;

public enum PetWingsEnum {
    HAVA_WING(1, "有翅膀"),
    NOT_WING(2, "没翅膀");
    Integer code;
    String text;

    PetWingsEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public static String getTextMeaning(int value) {
        for (PetWingsEnum examType : PetWingsEnum.values()) {
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
