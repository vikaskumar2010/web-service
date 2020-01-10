package com.vk.util;

import com.vk.model.*;

public class CommonUtils {

  private CommonUtils() {}

  public static <T> BaseResponse<T> getSuccessfulResponse(T payload) {
    return getResponse(payload, Status.OK);
  }

  public static <T> BaseResponse<T> getResponse(T payload, Status status) {
    BaseResponse<T> response = new BaseResponse<T>();
    response.setPayload(payload);
    response.setStatus(status);
    return response;
  }


}
