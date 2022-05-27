package com.bitc.ajax.service;

import com.bitc.ajax.dto.DailyBoxOfficeJsonDto;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;

import java.util.List;

public interface KobisService {
    Object getItemListUrl(String serviceUrl, String type) throws Exception;
}
