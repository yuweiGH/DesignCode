package metrice.viewer;

import java.util.Map;

import metrice.model.RequestStat;

import com.google.gson.Gson;

/**
 * @ClassName: ConsoleViewer
 * @Description:
 * @version: V1.0
 * @Author: JinYuwei
 * @Date: 2020/3/1
 */
public class ConsoleViewer implements StatViewer {
    public void output(
        Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMills + "]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStats));
    }
}

