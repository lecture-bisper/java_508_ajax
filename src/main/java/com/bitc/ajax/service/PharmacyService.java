package com.bitc.ajax.service;

import com.bitc.ajax.dto.PharmacyItemDto;

import java.util.List;

public interface PharmacyService {
  List<PharmacyItemDto> getItemList() throws Exception;

  List<PharmacyItemDto> getItemListUrl(String serviceUrl) throws Exception;
}
