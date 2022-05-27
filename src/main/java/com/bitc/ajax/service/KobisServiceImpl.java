package com.bitc.ajax.service;

import com.bitc.ajax.dto.*;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class KobisServiceImpl implements KobisService {
  @Override
  public Object getItemListUrl(String serviceUrl, String type) throws Exception {
    Object obj = null;

    URL url = null;
    HttpURLConnection urlConn = null;

    try {
      url = new URL(serviceUrl);
      urlConn = (HttpURLConnection) url.openConnection();
      urlConn.setRequestMethod("GET");

      if (type.equals("xml")) {
        JAXBContext jc = JAXBContext.newInstance(BoxOfficeDto.class);
        Unmarshaller um = jc.createUnmarshaller();

        BoxOfficeDto boxOfficeResult = (BoxOfficeDto) um.unmarshal(url);
        List<DailyBoxOfficeDto> itemList = boxOfficeResult.getDailyBoxOfficeList().getItemList();
        obj = itemList;
      }
      else {
//        getInputStream() : URL 클래스 객체에서 지정한 주소에 요청한 데이터를 가져옴
        InputStream in = new BufferedInputStream(urlConn.getInputStream());

//        BufferedReader br = new BufferedReader(new InputStreamReader(in));
//        String line;
//        StringBuilder sb = new StringBuilder();
//        while ((line = br.readLine()) != null) sb.append(line);
//        br.close();

//        Gson 객체 생성
        Gson gson = new Gson();
//        기존에 만들어진 Dto 클래스 타입에 맞춰서 JSON 데이터 가져오기
//        Gson을 이용하여 json 문자열을 자바의 지정한 클래스 타입으로 변환
        BoxOfficeJsonDto boxOfficeJsonResult = gson.fromJson(new InputStreamReader(in), BoxOfficeJsonDto.class);
        List<DailyBoxOfficeJsonDto> itemList = boxOfficeJsonResult.getBoxOfficeResult().getDailyBoxOfficeList();
        obj = itemList;
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      if (urlConn != null) {
        urlConn.disconnect();
      }
    }

    return obj;
  }
}


