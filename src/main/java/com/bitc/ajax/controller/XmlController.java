package com.bitc.ajax.controller;

import com.bitc.ajax.dto.Covid19InfoItemDto;
import com.bitc.ajax.dto.PharmacyItemDto;
import com.bitc.ajax.service.Covid19InfoService;
import com.bitc.ajax.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class XmlController {

  @Autowired
  private PharmacyService pharmacyService;

  @Autowired
  private Covid19InfoService covid19InfoService;

//  @Value : 해당 어노테이션은 application.properties 파일에 지정한 내용을 불러와서 사용할 수 있음
  @Value("${user.key}")
  private String secKey;

  @RequestMapping(value = "/pharmacy/fullData", method = RequestMethod.GET)
  public ModelAndView getPharmacyFullData() throws Exception {
    ModelAndView mv = new ModelAndView("/ajax/pharmacyList");

    List<PharmacyItemDto> itemList = pharmacyService.getItemList();
    mv.addObject("pharmacyDataList", itemList);

    return mv;
  }

  @ResponseBody
  @RequestMapping(value = "/pharmacy/ajaxFullData", method = RequestMethod.POST)
  public Object getAjaxPharmacyFullData(@RequestParam Map<String, String> request) throws Exception {

    List<PharmacyItemDto> itemList = pharmacyService.getItemList();

    return itemList;
  }

  @ResponseBody
  @RequestMapping(value = "/pharmacy/ajaxFullDataUrl", method = RequestMethod.POST)
  public Object getAjaxPharmacyFullDataUrl(@RequestParam("pageNo") int pageNo, @RequestParam("numOfRows") int numOfRows) throws Exception {
    String endPoint = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/";
    String serviceFunc = "getParmacyFullDown?";
    String serviceKey = "serviceKey=";
//    String serviceKey = "serviceKey=MQ8moCpDCqz42c3kxwz2LHfm%2BevXvXYOTYnrZjpLTYgYqArm4QD7hxWxCGM%2F24BBmgODLVMFUM6mAAH4XCFQcg%3D%3D";
    String option1 = "&pageNo=";
    String option2 = "&numOfRows=";

    String serviceUrl = endPoint + serviceFunc + serviceKey  + secKey + option1 + pageNo + option2 + numOfRows;

    List<PharmacyItemDto> itemList = pharmacyService.getItemListUrl(serviceUrl);

    return itemList;
  }

  @RequestMapping(value = "/covid19/infoState", method = RequestMethod.GET)
  public String getCovid19InfoState() throws Exception {
    return "/ajax/covid19Info";
  }

  @ResponseBody
  @RequestMapping(value = "/covid19/infoStateData", method = RequestMethod.POST)
  public Object getCovid19InfoState(@RequestParam("pageNo") String pageNo, @RequestParam("numOfRows") String numOfRows, @RequestParam("startCreateDt") String startCreateDt, @RequestParam("endCreateDt") String endCreateDt) throws Exception {
    String endPoint = "http://openapi.data.go.kr/openapi/service/rest/Covid19/";
    String serviceFunc = "getCovid19InfStateJson?";
    String serviceKey = "serviceKey=";
    String opt1 = "&pageNo=";
    String opt2 = "&numOfRows=";
    String opt3 = "&startCreateDt=";
    String opt4 = "&endCreateDt=";

    String serviceUrl = endPoint + serviceFunc + serviceKey  + secKey + opt1 + pageNo + opt2 + numOfRows + opt3 + startCreateDt.replace( "-", "") + opt4 + endCreateDt.replace("-", "");

    List<Covid19InfoItemDto> itemList = covid19InfoService.getItemListUrl(serviceUrl);

    return itemList;
  }
}
