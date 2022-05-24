package com.bitc.ajax.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class PharmacyBodyDto {
  private int totalCount;
  private int pageNo;
  private int numOfRows;
  private PharmacyItemsDto items;

  @XmlElement
  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  public int getPageNo() {
    return pageNo;
  }

  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;
  }

  public int getNumOfRows() {
    return numOfRows;
  }

  public void setNumOfRows(int numOfRows) {
    this.numOfRows = numOfRows;
  }

  @XmlElement(name = "items")
  public PharmacyItemsDto getItems() {
    return items;
  }

  public void setItems(PharmacyItemsDto items) {
    this.items = items;
  }
}
