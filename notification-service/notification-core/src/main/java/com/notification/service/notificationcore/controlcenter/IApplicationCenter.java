package com.notification.service.notificationcore.controlcenter;

public interface IApplicationCenter {
    boolean stopService();
    boolean isStopped();

    int getRequestCount();

    int incrementRequestCountAndGet();

    int decrementRequestCountAndGet();
}
