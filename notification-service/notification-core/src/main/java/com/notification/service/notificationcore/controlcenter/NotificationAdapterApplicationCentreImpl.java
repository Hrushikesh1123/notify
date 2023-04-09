package com.notification.service.notificationcore.controlcenter;

import com.notification.service.notificationcore.pool.IExecutorServicePool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Service(value = "notificationAdapterApplicationCentreImpl")
public class NotificationAdapterApplicationCentreImpl implements IApplicationCenter {
//    private static final Logger LOGGER= LoggerFactory.getLogger(NotificationAdapterApplicationCentreImpl.class);

    @Autowired
    @Qualifier("notificationAdapterExecutorServicePoolImpl")
    private IExecutorServicePool executorServicePool;

    private static final AtomicBoolean stopped=new AtomicBoolean(false);

    private static final AtomicInteger poolCounter=new AtomicInteger(1);

    @Override
    public boolean stopService() {
        stopped.set(true);
        try{
            executorServicePool.shutDown();
        }catch (final Exception ex){
//            LOGGER.error("error in stopping service : ",ex);
            return false;
        }
        return stopped.get();
    }

    @Override
    public boolean isStopped() {
        return stopped.get();
    }

    @Override
    public int getRequestCount() {
        return poolCounter.get();
    }

    @Override
    public int incrementRequestCountAndGet() {
        return poolCounter.incrementAndGet();
    }

    @Override
    public int decrementRequestCountAndGet() {
        return poolCounter.decrementAndGet();
    }
}
