package com.bitc.ajax.controller;

import com.bitc.ajax.dto.Covid19InfoItemDto;
import com.bitc.ajax.dto.DailyBoxOfficeDto;
import com.bitc.ajax.dto.DailyBoxOfficeJsonDto;
import com.bitc.ajax.service.Covid19InfoService;
import com.bitc.ajax.service.KobisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class KobisApiController {

  @Value("${user.kobis.key}")
  private String secKey;

  @Autowired
  private KobisService kobisService;


  @RequestMapping("/kobis/dailyBoxOfficeList")
  public String kobisDailyBoxOfficeList() throws Exception {
    return "/kobis/dailyBoxOfficeList";
  }

  @ResponseBody
  @RequestMapping(value = "/kobis/dailyBoxOfficeListXml", method = RequestMethod.POST)
  public List<DailyBoxOfficeDto> kobisDailyBoxOfficeListXml(@RequestParam("targetDt") String targetDt) throws Exception {
    String endPoint = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/";
    String serviceFunc = "searchDailyBoxOfficeList.xml?";
    String serviceKey = "key=";
    String opt1 = "&targetDt=";

    String serviceUrl = endPoint + serviceFunc + serviceKey  + secKey + opt1 + targetDt.replace( "-", "");

    List<DailyBoxOfficeDto> itemList = (List<DailyBoxOfficeDto>) kobisService.getItemListUrl(serviceUrl, "xml");

    return itemList;
  }

  @ResponseBody
  @RequestMapping(value = "/kobis/dailyBoxOfficeListJson", method = RequestMethod.POST)
  public Object kobisDailyBoxOfficeListJson(@RequestParam("targetDt") String targetDt) throws Exception {
    String endPoint = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/";
    String serviceFunc = "searchDailyBoxOfficeList.json?";
    String serviceKey = "key=";
    String opt1 = "&targetDt=";

    String serviceUrl = endPoint + serviceFunc + serviceKey  + secKey + opt1 + targetDt.replace( "-", "");

//    반환된 값이 Object 타입으로 되어 있으므로 사용 시 강제 타입 변환을 해줌
    List<DailyBoxOfficeJsonDto> itemList = (List<DailyBoxOfficeJsonDto>) kobisService.getItemListUrl(serviceUrl, "json");

    return itemList;
  }
}
