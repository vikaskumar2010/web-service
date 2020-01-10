package com.vk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.vk.config.TaskThreadPool;
import com.vk.model.*;
import com.vk.service.impl.Task;
import com.vk.util.CommonUtils;

@RestController
@RequestMapping(path = "/tasks")
public class TaskResource {

  @Autowired
  private ApplicationContext appContext;

  @Autowired
  private TaskThreadPool taskThreadpool;

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(code = HttpStatus.ACCEPTED)
  public BaseResponse<String> addTask(@RequestBody TaskRequest taskRequest) throws Exception {
    Task task = appContext.getBean(Task.class);
    task.init(taskRequest.getTaskId(), taskRequest.getTaskName());
    taskThreadpool.addRun(task);
    return CommonUtils.getResponse("Successfully added!", Status.ACCEPTED);
  }
}
