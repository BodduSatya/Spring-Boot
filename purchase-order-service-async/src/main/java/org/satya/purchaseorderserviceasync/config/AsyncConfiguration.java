package org.satya.purchaseorderserviceasync.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfiguration {

    @Bean("asyncTaskExecutor")
    public Executor  asyncTaskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor(); // ThreadPoolTaskExecutor object, which manages a pool of threads for executing tasks concurrently.
        taskExecutor.setCorePoolSize(4);                                    // Sets the core pool size to 4 threads. These threads are always present in the pool, ready to execute tasks immediately.
        taskExecutor.setQueueCapacity(150);                                 // Sets the queue capacity to 150 tasks. If all core threads are busy, new tasks are queued up to this limit.
        taskExecutor.setMaxPoolSize(4);                                     // Sets the maximum pool size to 4 threads. This means the pool won't grow beyond 4 threads, even if the queue is full.
        taskExecutor.setThreadNamePrefix("AsyncTaskThread-");               // Sets a prefix for thread names, helping with identification in logs or debugging. Threads in this pool will have names like "AsyncTaskThread-1", "AsyncTaskThread-2", etc.
        taskExecutor.initialize();                                          // Initializes the thread pool, starting the core threads and making it ready to accept tasks.
        return taskExecutor;
    }
}
