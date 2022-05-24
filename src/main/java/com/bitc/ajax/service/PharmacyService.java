package com.bitc.ajax.service;

import com.bitc.ajax.dto.PharmacyItemDto;

import java.util.List;

public interface PharmacyService {
  List<PharmacyItemDto> getItemList() throws Exception;
}
