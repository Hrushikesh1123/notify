package com.notification.service.notificationcore.pool;

import java.util.concurrent.ExecutionException;

public interface IExecutorServicePool {

    void submitJob(Runnable task) throws InterruptedException, ExecutionException;

    void shutDown() throws InterruptedException;
}
