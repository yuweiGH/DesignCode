package metrice.viewer;

import java.util.Map;

import metrice.model.RequestStat;

/**
 * @ClassName: StatViewer
 * @Description:
 * @version: V1.0
 * @Author: JinYuwei
 * @Date: 2020/3/1
 */
public interface StatViewer {
    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills);
}
