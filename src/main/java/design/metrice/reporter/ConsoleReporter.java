package design.metrice.reporter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import design.metrice.Aggregator;
import design.metrice.storage.MetricsStorage;
import design.metrice.storage.RedisMetricsStorage;
import design.metrice.viewer.ConsoleViewer;
import design.metrice.viewer.StatViewer;

/**
 * @ClassName: ConsoleReporter
 * @Description:
 * @version: V1.0
 * @Author: JinYuwei
 * @Date: 2020/3/1
 */

public class ConsoleReporter extends ScheduledReporter {
    private ScheduledExecutorService executor;

    public ConsoleReporter(){
        this(new RedisMetricsStorage(), new Aggregator(), new ConsoleViewer());
    }
    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    public void startRepeatedReport(long periodInSeconds, final long durationInSeconds) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long durationInMillis = durationInSeconds * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                doStatAndReport(startTimeInMillis, endTimeInMillis);
            }
        }, 0L, periodInSeconds, TimeUnit.SECONDS);
    }

}

