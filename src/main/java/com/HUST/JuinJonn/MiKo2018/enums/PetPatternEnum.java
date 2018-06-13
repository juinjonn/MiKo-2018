package com.HUST.JuinJonn.MiKo2018.enums;

public enum PetPatternEnum {
    PURPLE(1, "紫色"),
    PINK(2, "粉色"),
    GREEN(3, "绿色"),
    YELLOW(4, "黄色");
    Integer code;
    String text;

    PetPatternEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public static String getTextMeaning(int value) {
        for (PetPatternEnum examType : PetPatternEnum.values()) {
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
