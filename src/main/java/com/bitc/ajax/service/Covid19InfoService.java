package com.bitc.ajax.service;

import com.bitc.ajax.dto.Covid19InfoItemDto;

import java.util.List;

public interface Covid19InfoService {
  List<Covid19InfoItemDto> getItemListUrl(String serviceUrl) throws Exception;
}
