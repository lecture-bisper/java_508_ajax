package com.bitc.ajax.service;

import com.bitc.ajax.dto.Covid19InfoItemDto;
import com.bitc.ajax.dto.DailyBoxOfficeDto;

import java.util.List;

public interface KobisService {
    List<DailyBoxOfficeDto> getItemListUrl(String serviceUrl, String type) throws Exception;
}
