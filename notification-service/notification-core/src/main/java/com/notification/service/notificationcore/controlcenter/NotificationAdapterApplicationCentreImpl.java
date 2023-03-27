package com.notification.service.notificationcore.controlcenter;

import com.notification.service.notificationcore.pool.IExecutorServicePool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicBoolean;

@Service(value = "notificationAdapterApplicationCentreImpl")
public class NotificationAdapterApplicationCentreImpl implements IApplicationCenter{
    private static final Logger LOGGER= LoggerFactory.getLogger(NotificationAdapterApplicationCentreImpl.class);

    @Autowired
    @Qualifier("notificationAdapterExecutorServicePoolImpl")
    private IExecutorServicePool executorServicePool;

    private static final AtomicBoolean stopped=new AtomicBoolean(false);

    @Override
    public boolean stopService() {
        return false;
    }

    @Override
    public boolean isStopped() {
        return false;
    }

    @Override
    public int getRequestCount() {
        return 0;
    }

    @Override
    public int incrementRequestCountAndGet() {
        return 0;
    }

    @Override
    public int decrementRequestCountAndGet() {
        return 0;
    }
}
