package com.vk.exceptions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.vk.model.*;
import com.vk.model.Error;

@ControllerAdvice
public class ApplicationExceptionHandler {

  @ExceptionHandler(value = {Exception.class})
  public ResponseEntity<BaseResponse<Void>> handleException(Exception e) {
    BaseResponse<Void> response = new BaseResponse<Void>();

    HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    Status status = Status.SERVER_ERROR;

    if ( e instanceof ValidationFailureExcetion ) {
      status = Status.BAD_REQUEST;
      httpStatus = HttpStatus.BAD_REQUEST;
    }

    response.setStatus(status);
    response.setError(new Error(100, e.getMessage()));
    return new ResponseEntity<BaseResponse<Void>>(response, httpStatus);

  }
}
