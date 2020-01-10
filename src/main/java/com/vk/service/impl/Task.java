package com.vk.service.impl;

import org.slf4j.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Task implements Runnable {

  private static Logger LOGGER = LoggerFactory.getLogger(Task.class);

  private long taskId;
  private String taskName;
  private boolean initialized = false;

  public void init(long taskId, String taskName) {
    this.taskId = taskId;
    this.taskName = taskName;
    this.initialized = true;
  }

  @Override
  public void run() {
    int timeInSec = (int) (Math.random() * 10);
    try {
      LOGGER.info("Task details -- taskId={} taskName={}.. will run for {} seconds", taskId, taskName, timeInSec);
      Thread.sleep(timeInSec * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
