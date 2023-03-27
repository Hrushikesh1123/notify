package com.notification.service.notificationcore.config;

import com.kafka.api.integrate.kafkatoAPI.controlcenter.NotificationAdapterApplicationCentreImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    private static final Logger LOGGER= LoggerFactory.getLogger(NotificationAdapterApplicationCentreImpl.class);

    @Value("${min.pool.size}")
    private int minPoolSize;


    @Value("${max.pool.size}")
    private int maxPoolSize;


    @Value("${keep.alive.time}")
    private int keepAliveTimeInMillis;


    @Value("${shutdown.wait.time}")
    private int appShutDownTImeInMillis;


    @Value("${retry.count}")
    private int retryCount;


    @Value("${blocking.queue.pool.size}")
    private int blockingQueuePoolSize;

    @Value("${checkFromShadowMerchant}")
    private boolean checkForShadowMerchant;

    @Value("${web.client.timeout}")
    private int webClientTimeout;

    public int getMinPoolSize() {
        return minPoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public int getKeepAliveTimeInMillis() {
        return keepAliveTimeInMillis;
    }

    public int getAppShutDownTImeInMillis() {
        return appShutDownTImeInMillis;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public int getBlockingQueuePoolSize() {
        return blockingQueuePoolSize;
    }

    public boolean isCheckForShadowMerchant() {
        return checkForShadowMerchant;
    }

    public int getWebClientTimeout() {
        return webClientTimeout;
    }
}
