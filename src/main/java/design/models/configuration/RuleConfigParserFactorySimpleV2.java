package design.models.configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: RuleConfigParserFactorySimpleV2
 * @Description:
 * @version: V1.0
 * @Author: JinYuwei
 * @Date: 2020/3/7
 */
public class RuleConfigParserFactorySimpleV2 {

        private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<String, IRuleConfigParser>();

        static {
            cachedParsers.put("json", new JsonRuleConfigParser());
            cachedParsers.put("xml", new XmlRuleConfigParser());
            cachedParsers.put("yaml", new YamlRuleConfigParser());
            cachedParsers.put("properties", new PropertiesRuleConfigParser());
        }

        public static IRuleConfigParser createParser(String configFormat) {
            if (configFormat == null || configFormat.isEmpty()) {
                return null;//返回null还是IllegalArgumentException全凭你自己说了算
            }
            IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
            return parser;
        }
}
