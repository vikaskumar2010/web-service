package com.vk.config;

import java.util.concurrent.*;

import javax.annotation.*;

import org.slf4j.*;
import org.springframework.stereotype.Service;

import com.vk.exceptions.ApplicationException;

@Service
public class TaskThreadPool {

  private static Logger LOGGER = LoggerFactory.getLogger(TaskThreadPool.class);

  private ExecutorService executorService = null;

  private int minThreads = 1;

  private int maxThreads = 3;

  private int threadTTL = 10;

  private int queueSize = 5;

  private long shutdownWaitSeconds = 20;

  @PostConstruct
  public void init() {
    executorService = new ThreadPoolExecutor(minThreads, maxThreads, threadTTL, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(queueSize));

  }

  @PreDestroy
  public void shutdown() {

    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
    threadPoolExecutor.shutdown();
    while (!threadPoolExecutor.isTerminated()) {
      LOGGER.info("Waiting for threadpool to stop");
      try {
        threadPoolExecutor.awaitTermination(shutdownWaitSeconds, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        LOGGER.error("Threadpool stop interrupted", e);
        Thread.currentThread().interrupt();
      }
    }
    LOGGER.info("threadpool shutdown successfully");
  }

  public Future<?> addRun(Runnable r) throws Exception {

    try {
      return executorService.submit(r);
    } catch (RejectedExecutionException e) {
      LOGGER.error("Failed to add the task in threadpool.", e);

      throw new ApplicationException(e.getMessage(), e);
    }
  }

}
