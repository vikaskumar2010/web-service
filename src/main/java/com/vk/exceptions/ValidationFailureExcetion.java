package com.vk.exceptions;

public class ValidationFailureExcetion extends Exception {

  private static final long serialVersionUID = -2321467562885123896L;
  private String message;

  public ValidationFailureExcetion(String msg) {
    this.message = msg;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
