package com.vk.model;

public class Error {
  private int errorCode;
  private String errorMessage;

  public Error(int errorCode, String errorMessage) {
    super();
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Error [errorCode=").append(errorCode).append(", errorMessage=").append(errorMessage).append("]");
    return builder.toString();
  }

}
