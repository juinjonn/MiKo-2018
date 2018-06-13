package com.HUST.JuinJonn.MiKo2018.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {
    public static String ObjectToJson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            log.error("转换失败");
        }
        return json;
    }
}
