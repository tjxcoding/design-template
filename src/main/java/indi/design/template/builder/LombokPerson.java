package indi.design.template.builder;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author tjx
 * @since 2020-4-26
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LombokPerson {
    String name;
    Integer age;
    String mobile;
    String identity;
    String address;
}
