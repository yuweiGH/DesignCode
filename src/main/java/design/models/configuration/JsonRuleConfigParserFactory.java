package design.models.configuration;

/**
 * @ClassName: JsonRuleConfigParserFactory
 * @Description:
 * @version: V1.0
 * @Author: JinYuwei
 * @Date: 2020/3/7
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
