package com.bitc.ajax.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "boxOfficeResult")
public class BoxOfficeDto {
    private String boxofficeType;
    private String showRange;
    private DailyBoxOfficeListDto dailyBoxOfficeList;

    @XmlElement
    public String getBoxofficeType() {
        return boxofficeType;
    }

    public void setBoxofficeType(String boxofficeType) {
        this.boxofficeType = boxofficeType;
    }

    public String getShowRange() {
        return showRange;
    }

    public void setShowRange(String showRange) {
        this.showRange = showRange;
    }

    @XmlElement(name = "dailyBoxOfficeList")
    public DailyBoxOfficeListDto getDailyBoxOfficeList() {
        return dailyBoxOfficeList;
    }

    public void setDailyBoxOfficeList(DailyBoxOfficeListDto dailyBoxOfficeList) {
        this.dailyBoxOfficeList = dailyBoxOfficeList;
    }
}
