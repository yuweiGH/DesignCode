package design.metrice.reporter;

import java.util.List;
import java.util.Map;

import design.metrice.Aggregator;
import design.metrice.model.RequestInfo;
import design.metrice.model.RequestStat;
import design.metrice.storage.MetricsStorage;
import design.metrice.viewer.StatViewer;

/**
 * @ClassName: ScheduleReporter
 * @Description:
 * @version: V1.0
 * @Author: JinYuwei
 * @Date: 2020/3/1
 */

public abstract class ScheduledReporter {
    protected MetricsStorage metricsStorage;
    protected Aggregator aggregator;
    protected StatViewer viewer;

    public ScheduledReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    protected void doStatAndReport(long startTimeInMillis, long endTimeInMillis) {
        long durationInMillis = endTimeInMillis -  startTimeInMillis;
        Map<String, List<RequestInfo>> requestInfos =
            metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);
        viewer.output(requestStats, startTimeInMillis, endTimeInMillis);
    }

}