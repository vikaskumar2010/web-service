package com.vk.service.impl;

import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import com.vk.service.MathService;

@Service
public class MathServiceImpl implements MathService {


  /**
   * Default key is all the parameters. --- @Cacheable(value = "multiplication")
   * 
   * Key as only one parameter say x -- @Cacheable(value = "multiplication", key="#x")
   * 
   */

  @Cacheable(value = "multiplication", key = "{#root.method,#x,#y}", condition = "#x<10")
  @Override
  public long multiply(int x, int y) {
    System.out.println("Computing for x=" + x + " y=" + y);
    return x * y;
  }


  @Override
  @CacheEvict(value = "multiplication", allEntries = true)
  public void evictCache() {
    System.out.println("Cache eviction called!");
  }

}
