package com.bitc.ajax.controller;

import com.bitc.ajax.dto.CalDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AjaxController {

  @RequestMapping("/")
  public String index() throws Exception {
    return "index";
  }

  @RequestMapping(value = "/ajax/ajaxTestView", method = RequestMethod.GET)
  public String ajaxTestView() throws Exception {
    return "ajax/ajaxTestView";
  }

  @ResponseBody
  @RequestMapping(value = "/ajax/cal", method = RequestMethod.POST)
  public Object ajaxCal(CalDto data) throws Exception {
    data.setResult(data.getNum1() + data.getNum2());

    return data;
  }

  @GetMapping("/ajax/addrSelect")
  public String ajaxAddrSelect() throws Exception {
    return "ajax/selectBox";
  }

  @ResponseBody
  @PostMapping("/ajax/addrSelect")
  public Object ajaxAddrSelect(@RequestParam("areaName") String areaName) throws Exception {
    List<String> areaList = new ArrayList<>();

    if (areaName.equals("서울")) {
      areaList.add("강북구");
      areaList.add("강서구");
      areaList.add("강남구");
      areaList.add("강동구");
    }
    else if (areaName.equals("대전")) {
      areaList.add("유성구");
      areaList.add("동구");
      areaList.add("서구");
      areaList.add("중구");
    }
    else if (areaName.equals("대구")) {
      areaList.add("북구");
      areaList.add("동구");
      areaList.add("남구");
      areaList.add("서구");
    }
    else {
      areaList.add("부산진구");
      areaList.add("해운대구");
      areaList.add("수영구");
      areaList.add("동래구");
    }

    return areaList;
  }
}
