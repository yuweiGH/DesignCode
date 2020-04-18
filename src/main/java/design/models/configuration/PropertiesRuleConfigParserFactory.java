package design.models.configuration;

/**
 * @ClassName: PropertiesRuleConfigParserFactory
 * @Description:
 * @version: V1.0
 * @Author: JinYuwei
 * @Date: 2020/3/7
 */
public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new PropertiesRuleConfigParser();
    }
}
