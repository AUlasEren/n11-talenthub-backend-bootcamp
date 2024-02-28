package com.ulas.weatherapiapp.general;


public enum GeneralErrorMessage implements BaseErrorMessage {

  PRODUCT_NOT_FOUND("Item not found!");

  private final String message;

  GeneralErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return message;
  }
}
