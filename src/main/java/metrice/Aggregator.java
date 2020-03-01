package metrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import metrice.model.RequestInfo;
import metrice.model.RequestStat;

/**
 * @ClassName: Aggregator
 * @Description:
 * @version: V1.0
 * @Author: JinYuwei
 * @Date: 2020/3/1
 */

public class Aggregator {
    public Map<String, RequestStat> aggregate(
        Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {
        Map<String, RequestStat> requestStats = new HashMap<String, RequestStat>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfosPerApi, durationInMillis);
            requestStats.put(apiName, requestStat);
        }
        return requestStats;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        List<Double> respTimes = new ArrayList<Double>();
        for (RequestInfo requestInfo : requestInfos) {
            double respTime = requestInfo.getResponseTime();
            respTimes.add(respTime);
        }

        Collections.sort(respTimes, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                double diff = o1 - o2;
                if (diff < 0.0) {
                    return -1;
                } else if (diff > 0.0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(max(respTimes));
        requestStat.setMinResponseTime(min(respTimes));
        requestStat.setAvgResponseTime(avg(respTimes));
        requestStat.setP999ResponseTime(percentile999(respTimes));
        requestStat.setP99ResponseTime(percentile99(respTimes));
        requestStat.setCount(respTimes.size());
        requestStat.setTps((long) tps(respTimes.size(), durationInMillis / 1000));
        return requestStat;
    }

    // 以下的函数的代码实现均省略...
    private double max(List<Double> dataset) {
        double tmpTime = Double.MIN_VALUE;
        for (double respTime : dataset) {
            if (tmpTime < respTime) {
                tmpTime = respTime;
            }
        }
        return tmpTime;
    }

    private double min(List<Double> dataset) {
        double tmpTime = Double.MAX_VALUE;
        for (double respTime : dataset) {
            if (tmpTime < respTime) {
                tmpTime = respTime;
            }
        }
        return tmpTime;
    }

    private double avg(List<Double> dataset) {
        double tmpTime = 0;
        for (double respTime : dataset) {
            tmpTime += respTime;
        }
        return tmpTime / dataset.size();
    }

    private double tps(int count, double duration) {
        return (long) (count / duration);
    }

    private double percentile999(List<Double> dataset) {
        double tmpTime = 0.0;
        int count = dataset.size();
        int idx999 = (int) (count * 0.999);
        if (count != 0) {
            tmpTime = dataset.get(idx999);
        }
        return tmpTime;
    }

    private double percentile99(List<Double> dataset) {
        double tmpTime = 0.0;
        int count = dataset.size();
        int idx99 = (int) (count * 0.99);
        if (count != 0) {
            tmpTime = dataset.get(idx99);
        }
        return tmpTime;
    }

    private double percentile(List<Double> dataset, double ratio) {
        double tmpTime = 0.0;
        return tmpTime;
    }
}
