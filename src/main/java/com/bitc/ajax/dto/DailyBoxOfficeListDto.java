package com.bitc.ajax.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "dailyBoxOfficeList")
public class DailyBoxOfficeListDto {
    private List<DailyBoxOfficeDto> itemList;

    @XmlElement(name = "dailyBoxOffice")
    public List<DailyBoxOfficeDto> getItemList() {
        return itemList;
    }

    public void setItemList(List<DailyBoxOfficeDto> itemList) {
        this.itemList = itemList;
    }
}
