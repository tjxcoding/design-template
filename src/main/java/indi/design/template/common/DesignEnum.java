package indi.design.template.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author tjx
 * @since 2020-4-4
 */

@RequiredArgsConstructor
@Getter
public enum DesignEnum {

    proxy(1, "代理模式"),;

    private final int index;
    private final String desc;
}
