package indi.design.template.strategy;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @author tjx
 * @since 2020-4-23
 */
public class VerticalWeave implements Weave {

    @Override
    public String weaveString(String... strings) {
        StringJoiner joiner = new StringJoiner("|");
        Arrays.stream(strings).forEach(joiner::add);
        return joiner.toString();
    }
}
