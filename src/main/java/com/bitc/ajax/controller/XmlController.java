package com.bitc.ajax.controller;

import com.bitc.ajax.dto.PharmacyFullDataDto;
import com.bitc.ajax.dto.PharmacyItemDto;
import com.bitc.ajax.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class XmlController {

  @Autowired
  private PharmacyService pharmacyService;

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

//    https://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/
//    getParmacyFullDown?
//    serviceKey=MQ8moCpDCqz42c3kxwz2LHfm%2BevXvXYOTYnrZjpLTYgYqArm4QD7hxWxCGM%2F24BBmgODLVMFUM6mAAH4XCFQcg%3D%3D
//    &pageNo=1
//    &numOfRows=10

    List<PharmacyItemDto> itemList = pharmacyService.getItemList();

    return itemList;
  }
}
