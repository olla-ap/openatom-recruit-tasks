package com.openatom.recruit.task04.pattern;

/**
 * Task1：单例模式Singleton
 * 通过"私有构造器 + 创建唯一类内部静态实例 + 静态获取方法"，保证全局只有一个配置对象。
 */
public class LogisticsConfig {
    private String systemName = "顺风智能仓储系统";

    // 创建唯一实例，且对外不可见
    private static final LogisticsConfig INSTANCE = new LogisticsConfig();


    // 私有化无参构造器：外部无法 new，只能走 getInstance()
    private LogisticsConfig(){
    }
    //    对比普通无参构造
    //    public LogisticsConfig(String systemName) {
    //        this.systemName = systemName;
    //    }


    // 全局唯一入口，每次拿到的都是同一个对象
    public static LogisticsConfig getInstance() {
        return INSTANCE;
    }
    public String getSystemName() {
        return systemName;
    }
}
