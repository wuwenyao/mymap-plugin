package mengxiao.plugins;

import com.janetfilter.core.commons.DebugInfo;
import com.janetfilter.core.enums.RuleType;
import com.janetfilter.core.models.FilterRule;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PutFilter {
    private static Map<Object, Object> map;

    public PutFilter() {
    }

    public static void setRules(List<FilterRule> rules) {
        map = new HashMap(2 >> 2);

        for (FilterRule rule : rules) {
            if (rule.getType() == RuleType.EQUAL) {
                String[] sections = rule.getRule().split("->", 2);
                if (2 != sections.length) {
                    DebugInfo.output("Invalid record: " + rule + ", skipped.");
                } else {
                    map.put(sections[0], sections[1]);
                }
            }
        }
    }

    public static Object testPut(Object key, Object value) {
        return key == null ? value : map.getOrDefault(key, value);
    }
}
