package com.bitc.ajax.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.annotation.Generated;

//@Generated() : 해당 어노테이션은 자동으로 자바 소스를 생성하는 시스템이 생성한 소스라는 의미
@Generated("jsonschema2pojo")
public class BoxOfficeJsonDto {

//  @SerializedName : Gson 라이브러리 사용 시 json 코드와 java 코드를 연결하기 위한 어노테이션
//  @Expose : json 파일과 매칭 시 해당 값이 null일 경우 자동 생략해주는 어노테이션
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
