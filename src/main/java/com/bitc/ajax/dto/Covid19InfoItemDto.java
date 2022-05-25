package com.bitc.ajax.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class Covid19InfoItemDto {
  private String createDt; // 등록 시간
  private int deathCnt; // 사망자 수
  private int decideCnt; // 확진자 수
  private int seq; // 글번호
  private String stateDt; // 기준일
  private String stateTime; // 기준 시간
  private String updateDt; // 수정 시간

  @XmlElement
  public String getCreateDt() {
    return createDt;
  }

  public void setCreateDt(String createDt) {
    this.createDt = createDt;
  }

  public int getDeathCnt() {
    return deathCnt;
  }

  public void setDeathCnt(int deathCnt) {
    this.deathCnt = deathCnt;
  }

  public int getDecideCnt() {
    return decideCnt;
  }

  public void setDecideCnt(int decideCnt) {
    this.decideCnt = decideCnt;
  }

  public int getSeq() {
    return seq;
  }

  public void setSeq(int seq) {
    this.seq = seq;
  }

  public String getStateDt() {
    return stateDt;
  }

  public void setStateDt(String stateDt) {
    this.stateDt = stateDt;
  }

  public String getStateTime() {
    return stateTime;
  }

  public void setStateTime(String stateTime) {
    this.stateTime = stateTime;
  }

  public String getUpdateDt() {
    return updateDt;
  }

  public void setUpdateDt(String updateDt) {
    this.updateDt = updateDt;
  }
}
