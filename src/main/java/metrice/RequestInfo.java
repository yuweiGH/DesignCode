package metrice;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: RequestInfo
 * @Description:
 * @version: V1.0
 * @Author: JinYuwei
 * @Date: 2020/3/1
 */
@Setter
@Getter
public class RequestInfo {
    private String apiName;
    private double responseTime;
    private long timestamp;

    public RequestInfo(String apiName, double responseTime, long timestamp){
        this.apiName = apiName;
        this.responseTime = responseTime;
        this.timestamp = timestamp;
    }
}
