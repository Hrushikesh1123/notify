package com.notification.service.notificationcore.pool;

import com.notification.service.notificationcore.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service(value = "notificationAdapterExecutorServicePoolImpl")
public class NotificationAdapterExecutorServicePoolImpl implements IExecutorServicePool{

//    private static final Logger LOGGER= LoggerFactory.getLogger(NotificationAdapterExecutorServicePoolImpl.class);

    private static ThreadPoolExecutor servicePool;

    @Autowired
    private AppConfig appConfig;

//    @Autowired
//    @Qualifier("notificationAdapterApplicationCentreImpl")
//    private IApplicationCenter applicationCenter;

    @PostConstruct
    private void initAdapterServicePool(){
        servicePool=new ThreadPoolExecutor(appConfig.getMinPoolSize(), appConfig.getMaxPoolSize(), appConfig.getKeepAliveTimeInMillis(),
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(appConfig.getBlockingQueuePoolSize(), true), new ThreadFactory() {

            private final AtomicInteger threadCount=new AtomicInteger();
            @Override
            public Thread newThread(final Runnable target) {
                return new Thread();
            }
        },new ThreadPoolExecutor.CallerRunsPolicy());
    }


    @Override
    public void submitJob(Runnable task) throws InterruptedException, ExecutionException {
//        if (applicationCenter.isStopped()){
//            throw new InterruptedException("Notification adapter already stopped");
//        }
//        servicePool.submit(task);
//        LOGGER.info("Executor Service pool task submitted, Largest pool size:{}, Maz Pool size :{} , Queue Size : {} ",servicePool.getLargestPoolSize() ,servicePool.getMaximumPoolSize(),servicePool.getQueue().size());
    }

    @Override
    public void shutDown() throws InterruptedException {

        servicePool.shutdown();
        if (!servicePool.awaitTermination(appConfig.getAppShutDownTImeInMillis(),TimeUnit.MILLISECONDS)){

            final List<Runnable> droppedTasl=servicePool.shutdownNow();
//            LOGGER.warn("Notification Adater pool shutdown the task size not executed : {}",droppedTasl.size());
        }

    }
}
