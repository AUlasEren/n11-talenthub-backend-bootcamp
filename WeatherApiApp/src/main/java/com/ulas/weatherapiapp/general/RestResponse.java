package com.ulas.weatherapiapp.general;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class RestResponse<T> {

  private T data;
  private LocalDateTime responseDate;
  private boolean isSuccess;
  private String messages;

  public RestResponse(T data, boolean isSuccess){
    this.data = data;
    this.isSuccess = isSuccess;
    this.responseDate = LocalDateTime.now();
  }

  public static <T> RestResponse<T> of(T t){
    return new RestResponse<>(t, true);
  }

  public static <T> RestResponse<T> error(T t){
    return new RestResponse<>(t, false);
  }

  public static <T> RestResponse<T> empty(){
    return new RestResponse<>(null, true);
  }
  public RestResponse<T> message(String message) {
    this.messages = message;
    return this;
  }
  public RestResponse() {
    super();
  }
  @JsonCreator
  public RestResponse(@JsonProperty("data") T data,
                      @JsonProperty("isSuccess") boolean isSuccess,
                      @JsonProperty("messages") String messages) {
    this.data = data;
    this.isSuccess = isSuccess;
    this.responseDate = LocalDateTime.now();
    this.messages = messages;
  }
}
