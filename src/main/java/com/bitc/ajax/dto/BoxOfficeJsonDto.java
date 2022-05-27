package com.bitc.ajax.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class BoxOfficeJsonDto {

  @SerializedName("boxOfficeResult")
  @Expose
  private BoxOfficeResultJsonDto boxOfficeResult;

  public BoxOfficeResultJsonDto getBoxOfficeResult() {
    return boxOfficeResult;
  }

  public void setBoxOfficeResult(BoxOfficeResultJsonDto boxOfficeResult) {
    this.boxOfficeResult = boxOfficeResult;
  }
}
