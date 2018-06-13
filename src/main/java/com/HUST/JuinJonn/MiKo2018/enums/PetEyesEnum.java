package com.HUST.JuinJonn.MiKo2018.enums;

import lombok.Data;


public enum PetEyesEnum {

    VICIOUS_MONOCULAR(1, "凶残单眼"),
    OBSIDIAN(2, "凶残斜眼"),
    FOOL_EYES(3, "傻子眼"),
    EMERGING_EYES(4, "呆萌眼");
    Integer code;
    String text;

    PetEyesEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public static String getTextMeaning(int value) {
        for (PetEyesEnum examType : PetEyesEnum.values()) {
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
