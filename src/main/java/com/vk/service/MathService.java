package com.vk.service;

import com.vk.exceptions.ValidationFailureExcetion;

public interface MathService {

  long multiply(int x, int y) throws ValidationFailureExcetion;

  void evictCache();

}
