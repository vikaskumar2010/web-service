package com.vk.service.impl;

import org.springframework.cache.annotation.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.vk.exceptions.ValidationFailureExcetion;
import com.vk.service.MathService;

@Service
public class MathServiceImpl implements MathService {


  /**
   * Default key is all the parameters. --- @Cacheable(value = "multiplication")
   * 
   * Key as only one parameter say x -- @Cacheable(value = "multiplication", key="#x")
   * 
   * @throws ValidationFailureExcetion
   * 
   */

  @Cacheable(value = "multiplication", key = "{#root.method,#x,#y}", condition = "#x<10")
  @Override
  public long multiply(int x, int y) throws ValidationFailureExcetion {
    if ( x > 1000 ) {
      throw new ValidationFailureExcetion("Value of x must be less than or equal to 1000.");
    }
    System.out.println("Computing for x=" + x + " y=" + y);
    return x * y;
  }


  @Override
  @CacheEvict(value = "multiplication", allEntries = true)
  public void evictCache() {
    System.out.println("Cache eviction called!");
  }

  @Scheduled(fixedRate = 1 * 60 * 1000)
  public void testSchedule() {
    System.out.println("Scheduled called");

  }

}
