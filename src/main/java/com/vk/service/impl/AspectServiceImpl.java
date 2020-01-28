package com.vk.service.impl;

import org.springframework.stereotype.Service;

import com.vk.service.AspectService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AspectServiceImpl implements AspectService {


  @Override
  public int beforeExample() {
    log.info("Inside method.");
    return 10;
  }
  

}
