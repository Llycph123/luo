package com.luo.study.base.mode.Strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luolingyan
 * @description 环境上下文
 * @create 2025-02-17 10:50
 */
public class LoginStrategyManager {
    private static final LoginStrategyManager instance = new LoginStrategyManager();
    private Map<String, Class<LoginStrategy>> loginStrategies = new HashMap<>();

    public static LoginStrategyManager getInstance(){
        return instance;
    }

    private LoginStrategyManager(){
        init();
    }

    private void init(){
        register(LoginEnum.QQ.name(), QQLogin.class);
        register(LoginEnum.Dingding.name(), DingdingLogin.class);
    }

    public void register(String type, Class clazz){
        loginStrategies.put(type, clazz);
    }

    public LoginStrategy getLoginStrategy(String type) throws IllegalAccessException, InstantiationException {
        Class<LoginStrategy> clazz = loginStrategies.get(type);
        if(clazz != null){
            return (LoginStrategy)clazz.newInstance();
        }
        return null;
    }

}
