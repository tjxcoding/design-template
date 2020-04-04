package indi.design.template.observer;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author tjx
 * @since 2020-4-4
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectMessage {
    int id;
    String desc;
}
