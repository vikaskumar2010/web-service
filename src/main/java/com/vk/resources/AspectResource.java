package com.vk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vk.model.BaseResponse;
import com.vk.service.AspectService;
import com.vk.util.CommonUtils;

@RestController(value = "aspects")
public class AspectResource {

  @Autowired
  private AspectService aspectService;

  @RequestMapping(value = "before", method = RequestMethod.GET)
  public BaseResponse<Integer> testBeforeAspect() {
    return CommonUtils.getSuccessfulResponse(aspectService.beforeExample());
  }

}
