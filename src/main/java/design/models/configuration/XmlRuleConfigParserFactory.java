package design.models.configuration;

/**
 * @ClassName: XmlRuleConfigParserFactory
 * @Description:
 * @version: V1.0
 * @Author: JinYuwei
 * @Date: 2020/3/7
 */
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
