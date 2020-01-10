package com.vk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vk.exceptions.ValidationFailureExcetion;
import com.vk.model.BaseResponse;
import com.vk.service.MathService;
import com.vk.util.CommonUtils;

@RestController
public class MathResource {

  @Autowired
  private MathService mathService;

  @RequestMapping(path = "/multiply", method = RequestMethod.GET)
  public BaseResponse<Long> multily(@RequestParam(name = "x", required = true) int x, @RequestParam(name = "y", defaultValue = "5") int y)
      throws ValidationFailureExcetion {
    return CommonUtils.getSuccessfulResponse(mathService.multiply(x, y));
  }

  @RequestMapping(path = "/evictMultiplyCache", method = RequestMethod.GET)
  public BaseResponse<String> evictCacheMultiplication() {
    mathService.evictCache();
    return CommonUtils.getSuccessfulResponse("Cache cleared successfully!");
  }
}
