package com.openatom.recruit.task05;

/**
 * 自定义非受检异常（继承 RuntimeException）。
 * 提供带 cause 的构造器，用于把底层异常包装成统一对外提示（异常链）。
 */
public class SystemMaintenanceException extends RuntimeException {

    public SystemMaintenanceException(String message) {
        super(message);
    }

    public SystemMaintenanceException(String message, Throwable cause) {
        super(message, cause);   // 保留原始异常，方便日志里打印完整调用栈
    }
}
