package design.models.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JinYuwei
 * @Since: 2020/3/15
 */


public class UserController {
    private UserService userService; // 依赖注入
    private List<RegObserver> regObservers = new ArrayList<RegObserver>();

    // 一次性设置好，之后也不可能动态的修改
    public void setRegObservers(List<RegObserver> observers) {
        regObservers.addAll(observers);
    }

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password);

        for (RegObserver observer : regObservers) {
            observer.handleRegSuccess(userId);
        }

        return userId;
    }
}


interface RegObserver {
    void handleRegSuccess(long userId);
}

class RegPromotionObserver implements RegObserver {
    private PromotionService promotionService; // 依赖注入

    @Override
    public void handleRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}

class RegNotificationObserver implements RegObserver {
    private NotificationService notificationService;

    @Override
    public void handleRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId, "Welcome...");
    }
}

class UserService{

    public long register(String telephone, String password) {
        return 0;
    }
}

class PromotionService{
    public void issueNewUserExperienceCash(long userId) {

    }
}
class NotificationService{
    public void sendInboxMessage(long userId, String s) {

    }
}
