package indi.design.template.common;

import indi.design.template.observer.SubjectMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author tjx
 * @since 2020-4-10
 */
public class JsonUtilsTest {

    @Test
    public void beanToJson() throws Exception {
        String json = JsonUtils.beanToJson(subjectMessage());
        assertEquals(jsonString(), json);
    }

    @Test
    public void jsonToBean() throws Exception {
        SubjectMessage message = JsonUtils.jsonToBean(jsonString(), SubjectMessage.class);
        assertEquals(subjectMessage(), message);
    }

    private SubjectMessage subjectMessage() {
        SubjectMessage message = new SubjectMessage();
        message.setId(1);
        message.setDesc("test JsonUtils");
        return message;
    }

    private String jsonString() {
        return "{\"id\":1,\"desc\":\"test JsonUtils\"}";
    }
}