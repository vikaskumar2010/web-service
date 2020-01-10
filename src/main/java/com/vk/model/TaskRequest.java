package com.vk.model;

public class TaskRequest {

  private long taskId;

  private String taskName;

  public long getTaskId() {
    return taskId;
  }

  public void setTaskId(long taskId) {
    this.taskId = taskId;
  }

  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("TaskRequest [taskId=").append(taskId).append(", taskName=").append(taskName).append("]");
    return builder.toString();
  }



}
