package com.vk.resources;

import org.springframework.web.bind.annotation.*;

import com.vk.model.BaseResponse;
import com.vk.util.CommonUtils;

@RestController
public class HealthResource {

  @RequestMapping(path = "/alive", method = RequestMethod.GET)
  public BaseResponse<String> getApplicationStatus() {
    return CommonUtils.getSuccessfulResponse("It's up and running!");
  }

}
