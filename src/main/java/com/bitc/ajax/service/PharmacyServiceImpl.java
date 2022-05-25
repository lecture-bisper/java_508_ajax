package com.bitc.ajax.service;

import com.bitc.ajax.dto.*;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService {
  @Override
  public List<PharmacyItemDto> getItemList() throws Exception {

//    jaxb : 자바에서 xml 데이터를 자바 object 타입으로 파싱하도록 도와주는 라이브러리
//    Marshal(마샬) : 자바 클래스를 xml 데이터로 변환
//    UnMarshal(언마샬) : xml 데이터를 자바 클래스로 변환

//    JAXB 라이브러리 로드
//    JAXB 라이브러리를 통해서 xml 데이터와 연동할 자바 클래스를 설정
    JAXBContext jc = JAXBContext.newInstance(PharmacyFullDataDto.class);

//    언마샬 사용
    Unmarshaller um = jc.createUnmarshaller();

//    실제 xml 데이터 파일을 로드하여 jaxb 라이브러리로 언마샬 실행
//    ummarshal() 메서드의 반환값이 Object 이기 때문에 PharmacyFullDataDto 클래스 타입으로 강제 형변환
//    xml의 모든 데이터를 PharmacyFullDataDto 클래스 타입의 객체에 저장
    PharmacyFullDataDto fullData = (PharmacyFullDataDto) um.unmarshal(new File("C://java508//pharmacyFullData.xml"));
    PharmacyHeaderDto headerData = fullData.getHeader();
    PharmacyBodyDto bodyData = fullData.getBody();
    PharmacyItemsDto itemsData = bodyData.getItems();

//    실제 우리가 원하는 데이터만 추출
    List<PharmacyItemDto> itemList = itemsData.getItemList();

    return itemList;
  }

  @Override
  public List<PharmacyItemDto> getItemListUrl(String serviceUrl) throws Exception {
    List<PharmacyItemDto> itemList = null;

    // URL 클래스 : URL을 추상화하여 만든 클래스
    URL url = null;
//    HttpURLConnection 클래스 : 원격 자원에 접근하는데 필요한 정보를 가지고 있는 클래스
    HttpURLConnection urlConn = null;

//    네트워크라는 외부 자원을 사용하기 때문에 반드시 예외처리가 필요함
    try {
//      실제 url 주소를 가지고 객체화함
      url = new URL(serviceUrl);
//      지정된 url 주소로 접속
      urlConn = (HttpURLConnection) url.openConnection();
      urlConn.setRequestMethod("GET"); // GET 방식으로 접속

      JAXBContext jc = JAXBContext.newInstance(PharmacyFullDataDto.class);
      Unmarshaller um = jc.createUnmarshaller();

//      xml 파일 데이터가 아닌 외부 서버의 자원에 접근하여 xml 데이터를 파싱
      PharmacyFullDataDto fullData = (PharmacyFullDataDto) um.unmarshal(url);
      itemList = fullData.getBody().getItems().getItemList();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      if (urlConn != null) {
        urlConn.disconnect();
      }
    }

    return itemList;
  }
}
