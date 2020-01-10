package com.vk.exceptions;

public class ApplicationException extends Exception {

  private static final long serialVersionUID = -3096027675518155150L;

  private String message;
  private Exception exception;

  public ApplicationException() {

  }

  public ApplicationException(String message, Exception e) {
    this.message = message;
    this.exception = e;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Exception getException() {
    return exception;
  }

  public void setException(Exception exception) {
    this.exception = exception;
  }

}
