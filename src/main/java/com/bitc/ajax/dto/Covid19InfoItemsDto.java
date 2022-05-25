package com.bitc.ajax.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "items")
public class Covid19InfoItemsDto {
  private List<Covid19InfoItemDto> itemList;

  @XmlElement(name = "item")
  public List<Covid19InfoItemDto> getItemList() {
    return itemList;
  }

  public void setItemList(List<Covid19InfoItemDto> itemList) {
    this.itemList = itemList;
  }
}
