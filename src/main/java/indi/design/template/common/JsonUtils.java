package indi.design.template.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author tjx
 * @since 2020-4-10
 */
public class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String beanToJson(Object obj){
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LayoutPrint.printMsg(e);
            return "";
        }
    }

    public static <T> T jsonToBean(String json, Class<T> clzz) {
        try {
            return MAPPER.readValue(json, clzz);
        } catch (JsonProcessingException e) {
            LayoutPrint.printMsg(e);
            return null;
        }
    }

    static {
        // 排除json字符串中实体类没有的对象
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
