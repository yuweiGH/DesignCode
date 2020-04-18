package design.models.configuration;

/**
 * @ClassName: IRuleConfigParser
 * @Description:
 * @version: V1.0
 * @Author: JinYuwei
 * @Date: 2020/3/7
 */
public interface IRuleConfigParser {
    RuleConfig parse(String configText);
}
