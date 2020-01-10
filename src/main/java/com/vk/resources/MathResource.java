package com.vk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vk.service.MathService;

@RestController
public class MathResource {

  @Autowired
  private MathService mathService;

  @RequestMapping(path = "/multiply", method = RequestMethod.GET)
  public long multily(@RequestParam(name = "x", required = true) int x, @RequestParam(name = "y", defaultValue = "5") int y) {
    return mathService.multiply(x, y);
  }

  @RequestMapping(path = "/evictMultiplyCache", method = RequestMethod.GET)
  public String evictCacheMultiplication() {
    mathService.evictCache();
    return "Cache cleared successfully!";
  }
}
