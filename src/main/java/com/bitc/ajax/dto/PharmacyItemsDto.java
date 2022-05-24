package com.bitc.ajax.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "items")
public class PharmacyItemsDto {
  private List<PharmacyItemDto> itemList;

  @XmlElement(name = "item")
  public List<PharmacyItemDto> getItemList() {
    return itemList;
  }

  public void setItemList(List<PharmacyItemDto> itemList) {
    this.itemList = itemList;
  }
}
