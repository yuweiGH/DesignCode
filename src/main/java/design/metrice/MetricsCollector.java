package design.metrice;

import design.metrice.model.RequestInfo;
import design.metrice.storage.MetricsStorage;
import design.metrice.storage.RedisMetricsStorage;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: MetricsCollector
 * @Description:
 * @version: V1.0
 * @Author: JinYuwei
 * @Date: 2020/3/1
 */

public class MetricsCollector {
    private MetricsStorage metricsStorage;//基于接口而非实现编程

    public MetricsCollector(){
        this(new RedisMetricsStorage());
    }
    //依赖注入
    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    //用一个函数代替了最小原型中的两个函数
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}


